package day04;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

class BingoCardTest {
    @Test
    void testBingoCardRowMarked() {
        List<String> bingoCardNumbers = new ArrayList<>();
        bingoCardNumbers.add("22 13 17 11 0");
        bingoCardNumbers.add("8  2 23  4 24");
        bingoCardNumbers.add("21  9 14 16  7");
        bingoCardNumbers.add("6 10  3 18  5");
        bingoCardNumbers.add("1 12 20 15 19");

        BingoCard bingoCard = new BingoCard(bingoCardNumbers);
        bingoCard.setMarked(22);
        bingoCard.setMarked(13);
        bingoCard.setMarked(17);
        bingoCard.setMarked(11);
        bingoCard.setMarked(0);

        assertTrue(bingoCard.hasBingo());
    }

    @Test
    void testBingoCardColumnMarked() {
        List<String> bingoCardNumbers = new ArrayList<>();
        bingoCardNumbers.add("22 13 17 11 0");
        bingoCardNumbers.add("8  2 23  4 24");
        bingoCardNumbers.add("21  9 14 16  7");
        bingoCardNumbers.add("6 10  3 18  5");
        bingoCardNumbers.add("1 12 20 15 19");

        BingoCard bingoCard = new BingoCard(bingoCardNumbers);
        bingoCard.setMarked(13);
        bingoCard.setMarked(2);
        bingoCard.setMarked(9);
        bingoCard.setMarked(10);
        bingoCard.setMarked(12);

        assertTrue(bingoCard.hasBingo());
    }

    @Test
    void testBingoCardRowMarkedBing() {
        List<String> bingoCardNumbers = new ArrayList<>();
        bingoCardNumbers.add("22 13 17 11 0");
        bingoCardNumbers.add("8  2 23  4 24");
        bingoCardNumbers.add("21  9 14 16  7");
        bingoCardNumbers.add("6 10  3 18  5");
        bingoCardNumbers.add("1 12 20 15 19");

        BingoCard bingoCard = new BingoCard(bingoCardNumbers);
        assertFalse(bingoCard.setMarked(8));
        assertFalse(bingoCard.setMarked(2));
        assertFalse(bingoCard.setMarked(23));
        assertFalse(bingoCard.setMarked(4));
        assertTrue(bingoCard.setMarked(24));
    }

    @Test
    void testBingoCardColumnMarkedBingo() {
        List<String> bingoCardNumbers = new ArrayList<>();
        bingoCardNumbers.add("22 13 17 11 0");
        bingoCardNumbers.add("8  2 23  4 24");
        bingoCardNumbers.add("21  9 14 16  7");
        bingoCardNumbers.add("6 10  3 18  5");
        bingoCardNumbers.add("1 12 20 15 19");

        BingoCard bingoCard = new BingoCard(bingoCardNumbers);
        assertFalse(bingoCard.setMarked(11));
        assertFalse(bingoCard.setMarked(4));
        assertFalse(bingoCard.setMarked(16));
        assertFalse(bingoCard.setMarked(18));
        assertTrue(bingoCard.setMarked(15));
    }
}