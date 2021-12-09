package day08;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DisplayProcessor {

    List<String> inputList;
    public DisplayProcessor(List<String> inputList) {
        this.inputList = inputList;
    }

    public int[] decode() {
        int[] result = new int[10];
        for(String input : inputList) {
            SevenSegmentDisplayDecoder decoder = new SevenSegmentDisplayDecoder(input);
            int[] tmpResult = decoder.decode();
            for(int i=0; i < tmpResult.length; i++) {
                result[i] += tmpResult[i];
            }
        }
        return result;
    }

    public int getSumTotalParsedOutput() {
        int result = 0;
        for(String input : inputList) {
            SevenSegmentDisplayDecoder decoder = new SevenSegmentDisplayDecoder(input);
            result += Integer.parseInt(decoder.getDecodedOutput());

        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        List<String> inputList = new ArrayList<>();
        try (Stream<String> lines = Files.lines(Paths.get("src/day08/input_day08.txt"), Charset.defaultCharset())) {
            lines.forEachOrdered(inputList::add);
        }

        DisplayProcessor processor = new DisplayProcessor(inputList);
        int[] output = processor.decode();
        int totalCount = 0;
        for(int i=0; i < output.length; i++) {
            totalCount += output[i];
        }

        System.out.println("Instance count for (1,4,7,8): " + totalCount);
        System.out.println("Sum of all parsed output : " + processor.getSumTotalParsedOutput());
    }
}
