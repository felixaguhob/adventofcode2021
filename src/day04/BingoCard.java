package day04;

import java.util.List;

public class BingoCard {

    public class BingoCardBox {
        public boolean isMarked;
        public int cardNumber;

        public BingoCardBox(int cardNumber, boolean isMarked) {
            this.isMarked = isMarked;
            this.cardNumber = cardNumber;
        }
    }

    private int finalScore;
    private BingoCardBox[][] bingoCardNumbers = new BingoCardBox[5][5];
    public BingoCard(List<String> bingoCardNumbersInput) {
        int row = 0;
        for(String cardNumbers : bingoCardNumbersInput) {
            String[] numbers = cardNumbers.trim().replace(" ", "|").replace("||", "|").replace("|", " ").split(" ");
            for(int col=0; col < 5; col++) {
                bingoCardNumbers[row][col] = new BingoCardBox(Integer.parseInt(numbers[col]), false);
            }
            row++;
        }
        finalScore = 0;
    }

    public boolean setMarked(int number) {
        if (finalScore == 0 ) {
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 5; col++) {
                    if (bingoCardNumbers[row][col].cardNumber == number) {
                        bingoCardNumbers[row][col].isMarked = true;
                    }
                }
            }

            boolean hasBingo = hasBingo();
            if (hasBingo) {
                int sumOfNumbers = 0;
                for (int row = 0; row < 5; row++) {
                    for (int col = 0; col < 5; col++) {
                        if (!bingoCardNumbers[row][col].isMarked) {
                            sumOfNumbers += bingoCardNumbers[row][col].cardNumber;
                        }
                    }
                }
                finalScore = number * sumOfNumbers;
            }
            return hasBingo;
        } else {
            return true;
        }
    }

    public boolean hasBingo() {
        for(int row=0; row < 5; row++) {
            if (bingoCardNumbers[row][0].isMarked &&
                    bingoCardNumbers[row][1].isMarked &&
                    bingoCardNumbers[row][2].isMarked &&
                    bingoCardNumbers[row][3].isMarked &&
                    bingoCardNumbers[row][4].isMarked) {
                return true;
            }
        }

        for(int col=0; col < 5; col++) {
            if (bingoCardNumbers[0][col].isMarked &&
                    bingoCardNumbers[1][col].isMarked &&
                    bingoCardNumbers[2][col].isMarked &&
                    bingoCardNumbers[3][col].isMarked &&
                    bingoCardNumbers[4][col].isMarked) {
                return true;
            }
        }

        return false;
    }

    public int getFinalScore() {
        return finalScore;
    }
}
