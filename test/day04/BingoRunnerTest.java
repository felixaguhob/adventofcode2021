package day04;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BingoRunnerTest {
    @Test
    void testBingoRunnerGetFirstWinningCard() {
        List<String> bingoCardNumbers1 = new ArrayList<>();
        bingoCardNumbers1.add("22 13 17 11 0");
        bingoCardNumbers1.add("8  2 23  4 24");
        bingoCardNumbers1.add("21  9 14 16  7");
        bingoCardNumbers1.add("6 10  3 18  5");
        bingoCardNumbers1.add("1 12 20 15 19");

        List<String> bingoCardNumbers2 = new ArrayList<>();
        bingoCardNumbers2.add("3 15  0  2 22");
        bingoCardNumbers2.add("9 18 13 17  5");
        bingoCardNumbers2.add("19  8  7 25 23");
        bingoCardNumbers2.add("20 11 10 24  4");
        bingoCardNumbers2.add("14 21 16 12  6");

        List<String> bingoCardNumbers3 = new ArrayList<>();
        bingoCardNumbers3.add("14 21 17 24  4");
        bingoCardNumbers3.add("10 16 15  9 19");
        bingoCardNumbers3.add("18  8 23 26 20");
        bingoCardNumbers3.add("22 11 13  6  5");
        bingoCardNumbers3.add(" 2  0 12  3  7");


        BingoCard bingoCard1 = new BingoCard(bingoCardNumbers1);
        BingoCard bingoCard2 = new BingoCard(bingoCardNumbers2);
        BingoCard bingoCard3 = new BingoCard(bingoCardNumbers3);

        List<BingoCard> bingoCards = new ArrayList<>();
        bingoCards.add(bingoCard1);
        bingoCards.add(bingoCard2);
        bingoCards.add(bingoCard3);

        String drawNumbers = "7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1";
        BingoRunner bingoRunner = new BingoRunner(bingoCards, drawNumbers);

        assertEquals(bingoCard3, bingoRunner.GetFirstWinningCard());
        assertEquals(4512, bingoCard3.getFinalScore());
    }

    @Test
    void testBingoRunnerGetLastWinningCard() {
        List<String> bingoCardNumbers1 = new ArrayList<>();
        bingoCardNumbers1.add("22 13 17 11 0");
        bingoCardNumbers1.add("8  2 23  4 24");
        bingoCardNumbers1.add("21  9 14 16  7");
        bingoCardNumbers1.add("6 10  3 18  5");
        bingoCardNumbers1.add("1 12 20 15 19");

        List<String> bingoCardNumbers2 = new ArrayList<>();
        bingoCardNumbers2.add("3 15  0  2 22");
        bingoCardNumbers2.add("9 18 13 17  5");
        bingoCardNumbers2.add("19  8  7 25 23");
        bingoCardNumbers2.add("20 11 10 24  4");
        bingoCardNumbers2.add("14 21 16 12  6");

        List<String> bingoCardNumbers3 = new ArrayList<>();
        bingoCardNumbers3.add("14 21 17 24  4");
        bingoCardNumbers3.add("10 16 15  9 19");
        bingoCardNumbers3.add("18  8 23 26 20");
        bingoCardNumbers3.add("22 11 13  6  5");
        bingoCardNumbers3.add(" 2  0 12  3  7");


        BingoCard bingoCard1 = new BingoCard(bingoCardNumbers1);
        BingoCard bingoCard2 = new BingoCard(bingoCardNumbers2);
        BingoCard bingoCard3 = new BingoCard(bingoCardNumbers3);

        List<BingoCard> bingoCards = new ArrayList<>();
        bingoCards.add(bingoCard1);
        bingoCards.add(bingoCard2);
        bingoCards.add(bingoCard3);

        String drawNumbers = "7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1";
        BingoRunner bingoRunner = new BingoRunner(bingoCards, drawNumbers);

        assertEquals(bingoCard2, bingoRunner.getLastWinningCard());
        assertEquals(1924, bingoCard2.getFinalScore());
    }
}