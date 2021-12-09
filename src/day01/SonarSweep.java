package day01;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class SonarSweep {
    public int countIncreases(List<String> inputList) {
        int counter = 0;
        Iterator<String> listIter = inputList.listIterator();
        if (listIter.hasNext()) {
            int first = Integer.parseInt(listIter.next());
            int second;

            while (listIter.hasNext()) {
                second = Integer.parseInt(listIter.next());
                if (first < second) {
                    counter++;
                }
                first = second;
            }
        }
        return counter;
    }

    public int countIncreasesSlidingWindow(List<String> inputList) {
        List<String> sumList = new ArrayList<>();

        for(int i = 0; i < inputList.size()-2; i++) {
            int sum = Integer.parseInt(inputList.get(i)) +
                    Integer.parseInt(inputList.get(i+1)) +
                    Integer.parseInt(inputList.get(i+2));
            sumList.add(Integer.toString(sum));
        }

        return countIncreases(sumList);
    }

    public void runWithInput(String inputFile) throws IOException{
        List<String> inputList = new ArrayList<>();
        try (Stream<String> lines = Files.lines(Paths.get(inputFile), Charset.defaultCharset())) {
            lines.forEachOrdered(inputList::add);
        }

        int countIncrease = this.countIncreases(inputList);
        int countThreeWindowIncrease = countIncreasesSlidingWindow(inputList);

        System.out.println("Number of increases: " + countIncrease);
        System.out.println("Number of increases(Three-Measurement Sliding Window): " + countThreeWindowIncrease);
    }

    public static void main(String[] args) throws IOException {
        SonarSweep sonarSweep = new SonarSweep();
        sonarSweep.runWithInput("./src/day01/input_day01.txt");
    }
}
