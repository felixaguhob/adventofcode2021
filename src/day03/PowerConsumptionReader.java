package day03;


import day02.Submarine;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class PowerConsumptionReader {

    public class BitCountHolder {
        public int setBitCount;
        public int unsetBitCount;
    }

    private int gammaRate;
    private int epsilonRate;

    public PowerConsumptionReader() {
        gammaRate = 0;
        epsilonRate = 0;
    }

    public int getGammaRate() {
        return gammaRate;
    }

    public int getEpsilonRate() {
        return epsilonRate;
    }

    public BitCountHolder[] computeCommonBits(List<String> bits) {
        BitCountHolder[] bitCountHolders = new BitCountHolder[255];
        for(String bit : bits) {
            for(int i=0; i < bit.length(); i++) {
                if (bitCountHolders[i] == null) {
                    bitCountHolders[i] = new BitCountHolder();
                }
                char tmp = bit.charAt(i);
                if (tmp == '0') {
                    bitCountHolders[i].unsetBitCount++;
                } else if (tmp == '1') {
                    bitCountHolders[i].setBitCount++;
                }
            }
        }
        return bitCountHolders;
    }

    public int[] getMostCommonBitPerPosition(List<String> bits) {
        int maxLength = bits.get(0).length();
        int[] commonBitPerPosition = new int[maxLength];
        BitCountHolder[] bitCounterHolders = computeCommonBits(bits);

        for(int i=0; i < maxLength; i++) {
            if (bitCounterHolders[i].setBitCount > bitCounterHolders[i].unsetBitCount) {
                commonBitPerPosition[i] = 1;
            } else {
                commonBitPerPosition[i] = 0;
            }
        }
        return commonBitPerPosition;
    }

    public int computeGammaRate(List<String> inputBits) {
        int[] bits = getMostCommonBitPerPosition(inputBits);
        StringBuilder tmp = new StringBuilder();
        for (int bit : bits) {
            tmp.append(bit);
        }
        return Integer.parseInt(tmp.toString(), 2);
    }

    public int[] getLeastCommonBitPerPosition(List<String> bits) {
        int maxLength = bits.get(0).length();
        int[] leastCommonBitPerPosition = new int[maxLength];
        BitCountHolder[] bitCounterHolders = computeCommonBits(bits);

        for(int i=0; i < maxLength; i++) {
            if (bitCounterHolders[i].setBitCount > bitCounterHolders[i].unsetBitCount) {
                leastCommonBitPerPosition[i] = 0;
            } else {
                leastCommonBitPerPosition[i] = 1;
            }
        }
        return leastCommonBitPerPosition;
    }

    public int computeEpsilonRate(List<String> inputBits) {
        int[] bits = getLeastCommonBitPerPosition(inputBits);
        StringBuilder tmp = new StringBuilder();
        for (int bit : bits) {
            tmp.append(bit);
        }
        return Integer.parseInt(tmp.toString(), 2);
    }

    public int getOxygenGeneratorRating(List<String> inputBits) {
        BitCountHolder[] bitCounts = computeCommonBits(inputBits);

        List<String> rating = searchOxygenGeneratorRating(inputBits, bitCounts, 0);

        return Integer.parseInt(rating.get(0), 2);
    }

    private List<String> searchOxygenGeneratorRating(List<String> inputBits,  BitCountHolder[] referenceBits, int curPos) {
        if (inputBits.size() == 1)
            return inputBits;

        List<String> filtered = new ArrayList<>();
        for(String inputBit : inputBits) {
            char bitToCheck = inputBit.charAt(curPos);
            if (referenceBits[curPos].setBitCount > referenceBits[curPos].unsetBitCount) {
                if (bitToCheck == '1') {
                    filtered.add(inputBit);
                }
            } else if (referenceBits[curPos].setBitCount < referenceBits[curPos].unsetBitCount) {
                if (bitToCheck == '0') {
                    filtered.add(inputBit);
                }
            } else {
                if (bitToCheck == '1') {
                    filtered.add(inputBit);
                }
            }
        }

        BitCountHolder[] bitCounts = computeCommonBits(filtered);

        curPos +=1;
        return searchOxygenGeneratorRating(filtered, bitCounts, curPos);
    }

    public int getCO2ScrubberRating(List<String> inputBits) {
        BitCountHolder[] bitCounts = computeCommonBits(inputBits);

        List<String> rating = searchCO2ScrubberRating(inputBits, bitCounts, 0);

        return Integer.parseInt(rating.get(0), 2);
    }

    private List<String> searchCO2ScrubberRating(List<String> inputBits,  BitCountHolder[] referenceBits, int curPos) {
        if (inputBits.size() == 1)
            return inputBits;

        List<String> filtered = new ArrayList<>();
        for(String inputBit : inputBits) {
            char bitToCheck = inputBit.charAt(curPos);
            if (referenceBits[curPos].setBitCount > referenceBits[curPos].unsetBitCount) {
                if (bitToCheck == '0') {
                    filtered.add(inputBit);
                }
            } else if (referenceBits[curPos].setBitCount < referenceBits[curPos].unsetBitCount) {
                if (bitToCheck == '1') {
                    filtered.add(inputBit);
                }
            } else {
                if (bitToCheck == '0') {
                    filtered.add(inputBit);
                }
            }
        }

        BitCountHolder[] bitCounts = computeCommonBits(filtered);

        curPos +=1;
        return searchCO2ScrubberRating(filtered, bitCounts, curPos);
    }

    public static void main(String[] args) throws IOException {
        List<String> inputList = new ArrayList<>();
        try (Stream<String> lines = Files.lines(Paths.get("input_day03.txt"), Charset.defaultCharset())) {
            lines.forEachOrdered(inputList::add);
        }

        PowerConsumptionReader pcr = new PowerConsumptionReader();
        int epsilonRate = pcr.computeEpsilonRate(inputList);
        int gammaRate = pcr.computeGammaRate(inputList);
        int oxgenGeneratorRating = pcr.getOxygenGeneratorRating(inputList);
        int CO2ScrubberRating = pcr.getCO2ScrubberRating(inputList);

        System.out.println("Gamma Rate: " + gammaRate);
        System.out.println("Epsilon Rate: " + epsilonRate);
        System.out.println("Power Consumption: " + epsilonRate * gammaRate);
        System.out.println("Oxygen Generator Rating: " + oxgenGeneratorRating);
        System.out.println("CO2 Scrubber Rating: " + CO2ScrubberRating);
        System.out.println("Life Support Rating: " + oxgenGeneratorRating * CO2ScrubberRating);
    }
}
