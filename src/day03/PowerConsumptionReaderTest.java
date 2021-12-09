package day03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PowerConsumptionReaderTest {

    @Test
    void testPowerConsumptionReaderGetGammaRate() {
        PowerConsumptionReader powerConsumptionReader = new PowerConsumptionReader();

        assertEquals(0, powerConsumptionReader.getGammaRate());
    }

    @Test
    void testPowerConsumptionReaderGetEpsilonRate() {
        PowerConsumptionReader powerConsumptionReader = new PowerConsumptionReader();

        assertEquals(0, powerConsumptionReader.getEpsilonRate());
    }

    @Test
    void testComputeCommonBitsReturnValidBitCounts() {
        List<String> bits = new ArrayList<>();
        bits.add("1");
        PowerConsumptionReader pcr = new PowerConsumptionReader();
        PowerConsumptionReader.BitCountHolder[] result = pcr.computeCommonBits(bits);

        assertEquals(1, result[0].setBitCount);
        assertEquals(0, result[0].unsetBitCount);
    }

    @Test
    void testComputeCommonBitsReturnValidBitCount3Bits() {
        List<String> bits = new ArrayList<>();
        bits.add("10");
        bits.add("10");
        bits.add("01");
        PowerConsumptionReader pcr = new PowerConsumptionReader();
        PowerConsumptionReader.BitCountHolder[] result = pcr.computeCommonBits(bits);

        assertEquals(2, result[0].setBitCount);
        assertEquals(1, result[0].unsetBitCount);
        assertEquals(1, result[1].setBitCount);
        assertEquals(2, result[1].unsetBitCount);
    }

    @Test
    void testGetMostCommonBitPerPosition() {
        List<String> bits = new ArrayList<>();
        bits.add("00100");
        bits.add("11110");
        bits.add("10110");
        bits.add("10111");
        bits.add("10101");
        bits.add("01111");
        bits.add("00111");
        bits.add("11100");
        bits.add("10000");
        bits.add("11001");
        bits.add("00010");
        bits.add("01010");
        PowerConsumptionReader pcr = new PowerConsumptionReader();
        int[] result = pcr.getMostCommonBitPerPosition(bits);

        assertEquals(1, result[0]);
        assertEquals(0, result[1]);
        assertEquals(1, result[2]);
        assertEquals(1, result[3]);
        assertEquals(0, result[4]);
    }


    @Test
    void testComputeGammaRate() {
        List<String> bits = new ArrayList<>();
        bits.add("00100");
        bits.add("11110");
        bits.add("10110");
        bits.add("10111");
        bits.add("10101");
        bits.add("01111");
        bits.add("00111");
        bits.add("11100");
        bits.add("10000");
        bits.add("11001");
        bits.add("00010");
        bits.add("01010");
        PowerConsumptionReader pcr = new PowerConsumptionReader();

        assertEquals(22, pcr.computeGammaRate(bits));
    }

    @Test
    void testGetLeastCommonBitPerPosition() {
        List<String> bits = new ArrayList<>();
        bits.add("00100");
        bits.add("11110");
        bits.add("10110");
        bits.add("10111");
        bits.add("10101");
        bits.add("01111");
        bits.add("00111");
        bits.add("11100");
        bits.add("10000");
        bits.add("11001");
        bits.add("00010");
        bits.add("01010");
        PowerConsumptionReader pcr = new PowerConsumptionReader();
        int[] result = pcr.getLeastCommonBitPerPosition(bits);

        assertEquals(0, result[0]);
        assertEquals(1, result[1]);
        assertEquals(0, result[2]);
        assertEquals(0, result[3]);
        assertEquals(1, result[4]);
    }

    @Test
    void testComputeEpsilonRate() {
        List<String> bits = new ArrayList<>();
        bits.add("00100");
        bits.add("11110");
        bits.add("10110");
        bits.add("10111");
        bits.add("10101");
        bits.add("01111");
        bits.add("00111");
        bits.add("11100");
        bits.add("10000");
        bits.add("11001");
        bits.add("00010");
        bits.add("01010");
        PowerConsumptionReader pcr = new PowerConsumptionReader();

        assertEquals(9, pcr.computeEpsilonRate(bits));
    }

    @Test
    void testGetOxygenGeneratorRating() {
        List<String> bits = new ArrayList<>();
        bits.add("00100");
        bits.add("11110");
        bits.add("10110");
        bits.add("10111");
        bits.add("10101");
        bits.add("01111");
        bits.add("00111");
        bits.add("11100");
        bits.add("10000");
        bits.add("11001");
        bits.add("00010");
        bits.add("01010");
        PowerConsumptionReader pcr = new PowerConsumptionReader();

        assertEquals(23, pcr.getOxygenGeneratorRating(bits));
    }

    @Test
    void testGetCO2ScrubberRating() {
        List<String> bits = new ArrayList<>();
        bits.add("00100");
        bits.add("11110");
        bits.add("10110");
        bits.add("10111");
        bits.add("10101");
        bits.add("01111");
        bits.add("00111");
        bits.add("11100");
        bits.add("10000");
        bits.add("11001");
        bits.add("00010");
        bits.add("01010");
        PowerConsumptionReader pcr = new PowerConsumptionReader();

        assertEquals(10, pcr.getCO2ScrubberRating(bits));
    }
}