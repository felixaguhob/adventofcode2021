package day08;

import org.junit.jupiter.api.Test;


import static org.junit.Assert.*;

class SevenSegmentDisplayDecoderTest {
    @Test
    void testSevenSegmentDisplayDecoderInit() {
        String input = "be cfbegad cbdgef fgaecd cgeb fdcge agebfd fecdb fabcd edb | fdgacbe cefdb cefbgd gcbe";
        SevenSegmentDisplayDecoder decoder = new SevenSegmentDisplayDecoder(input);

        int[] output = decoder.decode();
        assertEquals(1, output[4]);
        assertEquals(1, output[8]);

        assertEquals(8394, decoder.getDecodedOutput());
    }

    @Test
    void testSevenSegmentDisplayDecoder2() {
        String input = "edbfga begcd cbg gc gcadebf fbgde acbgfd abcde gfcbed gfec | fcgedb cgb dgebacf gc";
        SevenSegmentDisplayDecoder decoder = new SevenSegmentDisplayDecoder(input);

        int[] output = decoder.decode();
        int totalCount = 0;
        for(int i=0; i < output.length; i++) {
            totalCount += output[i];
        }

        assertEquals(9781, decoder.getDecodedOutput());
    }
}