package day04;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class BingoRunner {

    private List<BingoCard> bingoCards;
    private String[] drawNumbers;
    private int finalScore;
    public BingoRunner(List<BingoCard> bingoCards, String drawNumbers) {
        this.bingoCards = bingoCards;
        this.drawNumbers = drawNumbers.split(",");
        finalScore = 0;
    }

    public BingoCard GetFirstWinningCard() {
        for(String drawNumber : drawNumbers) {
            for (BingoCard bingoCard: bingoCards) {
                if (bingoCard.setMarked(Integer.parseInt(drawNumber))) {
                    return bingoCard;
                }
            }
        }
        return null;
    }

    public BingoCard getLastWinningCard() {
        Set<BingoCard> winningCards = new LinkedHashSet<>();
        for(String drawNumber : drawNumbers) {
            for (BingoCard bingoCard: bingoCards) {
                bingoCard.setMarked(Integer.parseInt(drawNumber));
                if(bingoCard.hasBingo()) {
                    winningCards.add(bingoCard);
                }
            }
        }
        return winningCards.stream().skip(winningCards.size()-1).findFirst().get();
    }

    public static void main(String[] args) throws IOException {
        String drawNumbers = Files.readString(Paths.get("input_day04_drawNumbers.txt"), StandardCharsets.US_ASCII);
        List<BingoCard> bingoCards = new ArrayList<>();
        List<String> bingoCardNumbers = new ArrayList<>();
        try (Stream<String> lines = Files.lines(Paths.get("input_day04_BingoCards.txt"), Charset.defaultCharset())) {
            lines.forEachOrdered(line -> {
                if (line.trim().equals("")) {
                    if (bingoCardNumbers.size() > 0) {
                        BingoCard bingoCard = new BingoCard(bingoCardNumbers);
                        bingoCards.add(bingoCard);
                    }

                    bingoCardNumbers.clear();
                } else {
                    bingoCardNumbers.add(line);
                }
            });
        }
        BingoCard bingoCard = new BingoCard(bingoCardNumbers);
        bingoCards.add(bingoCard);
        bingoCardNumbers.clear();

        BingoRunner bingoRunner = new BingoRunner(bingoCards, drawNumbers);

        BingoCard firstWinningCard = bingoRunner.GetFirstWinningCard();
        BingoCard lastWinningCard = bingoRunner.getLastWinningCard();
        System.out.println("First Winning Card Final Score: " + firstWinningCard.getFinalScore());
        System.out.println("Last Winning Card Final Score: " + lastWinningCard.getFinalScore());
    }
}
