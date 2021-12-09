package day08;

import org.junit.jupiter.api.Test;


import static org.junit.Assert.*;

class SevenSegmentDisplayDecoderTest {
    @Test
    void testSevenSegmentDisplayDecode1() {
        String input = "edbfga begcd cbg gc gcadebf fbgde acbgfd abcde gfcbed gfec | fcgedb cgb dgebacf gc";
        SevenSegmentDisplayDecoder decoder = new SevenSegmentDisplayDecoder(input);

        int[] output = decoder.decode();
        assertEquals(1, output[1]);
    }

    @Test
    void testSevenSegmentDisplayDecode7() {
        String input = "edbfga begcd cbg gc gcadebf fbgde acbgfd abcde gfcbed gfec | fcgedb cgb dgebacf gc";
        SevenSegmentDisplayDecoder decoder = new SevenSegmentDisplayDecoder(input);

        int[] output = decoder.decode();
        assertEquals(1, output[7]);
    }

    @Test
    void testSevenSegmentDisplayDecode4() {
        String input = "be cfbegad cbdgef fgaecd cgeb fdcge agebfd fecdb fabcd edb | fdgacbe cefdb cefbgd gcbe";
        SevenSegmentDisplayDecoder decoder = new SevenSegmentDisplayDecoder(input);

        int[] output = decoder.decode();
        assertEquals(1, output[4]);
    }

    @Test
    void testSevenSegmentDisplayDecode8() {
        String input = "be cfbegad cbdgef fgaecd cgeb fdcge agebfd fecdb fabcd edb | fdgacbe cefdb cefbgd gcbe";
        SevenSegmentDisplayDecoder decoder = new SevenSegmentDisplayDecoder(input);

        int[] output = decoder.decode();
        assertEquals(1, output[8]);
    }

    @Test
    void testSevenSegmentDisplayDecode3() {
        String input = "be cfbegad cbdgef fgaecd cgeb fdcge agebfd fecdb fabcd edb | fdgacbe cefdb cefbgd gcbe";
        SevenSegmentDisplayDecoder decoder = new SevenSegmentDisplayDecoder(input);

        decoder.decodeNumbers();
        assertTrue(decoder.getDecodedOutput().contains("3"));
    }

    @Test
    void testSevenSegmentDisplayDecode5() {
        String input = "gcafb gcf dcaebfg ecagb gf abcdeg gaef cafbge fdbac fegbdc | fgae cfgab fg bagce";
        SevenSegmentDisplayDecoder decoder = new SevenSegmentDisplayDecoder(input);

        decoder.decodeNumbers();
        assertTrue(decoder.getDecodedOutput().contains("5"));
    }

    @Test
    void testSevenSegmentDisplayDecode2() {
        String input = "bdfegc cbegaf gecbf dfcage bdacg ed bedf ced adcbefg gebcd | ed bcgafe cdgba cbgef";
        SevenSegmentDisplayDecoder decoder = new SevenSegmentDisplayDecoder(input);

        decoder.decodeNumbers();
        assertTrue(decoder.getDecodedOutput().contains("2"));
    }

    @Test
    void testSevenSegmentDisplayDecode9() {
        String input = "be cfbegad cbdgef fgaecd cgeb fdcge agebfd fecdb fabcd edb | fdgacbe cefdb cefbgd gcbe";
        SevenSegmentDisplayDecoder decoder = new SevenSegmentDisplayDecoder(input);

        decoder.decodeNumbers();
        assertTrue(decoder.getDecodedOutput().contains("9"));
    }

    @Test
    void testSevenSegmentDisplayDecode6() {
        String input = "bdfegc cbegaf gecbf dfcage bdacg ed bedf ced adcbefg gebcd | ed bcgafe cdgba cbgef";
        SevenSegmentDisplayDecoder decoder = new SevenSegmentDisplayDecoder(input);

        decoder.decodeNumbers();
        assertTrue(decoder.getDecodedOutput().contains("6"));
    }

    @Test
    void testSevenSegmentDisplayDecodedOutputWith1789() {
        String input = "edbfga begcd cbg gc gcadebf fbgde acbgfd abcde gfcbed gfec | fcgedb cgb dgebacf gc";
        SevenSegmentDisplayDecoder decoder = new SevenSegmentDisplayDecoder(input);

        assertEquals(9781, Integer.parseInt(decoder.getDecodedOutput()));
    }

    @Test
    void testSevenSegmentDisplayDecodedOutputWith256() {
        String input = "bdfegc cbegaf gecbf dfcage bdacg ed bedf ced adcbefg gebcd | ed bcgafe cdgba cbgef";
        SevenSegmentDisplayDecoder decoder = new SevenSegmentDisplayDecoder(input);

        assertEquals(1625, Integer.parseInt(decoder.getDecodedOutput()));
    }

    @Test
    void testSevenSegmentDisplayDecodedOutputWith34() {
        String input = "be cfbegad cbdgef fgaecd cgeb fdcge agebfd fecdb fabcd edb | fdgacbe cefdb cefbgd gcbe";
        SevenSegmentDisplayDecoder decoder = new SevenSegmentDisplayDecoder(input);

        assertEquals(8394, Integer.parseInt(decoder.getDecodedOutput()));
    }
}