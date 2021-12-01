package day01;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SonarSweepTest {
    @Test
    void TestCountIncreasesWithValidInput() {
        List<String> inputList = new ArrayList<>();
        inputList.add("199");
        inputList.add("200");
        inputList.add("208");
        inputList.add("210");
        inputList.add("200");
        inputList.add("207");
        inputList.add("240");
        inputList.add("269");
        inputList.add("260");
        inputList.add("263");

        SonarSweep sonar = new SonarSweep();
        assertEquals(7, sonar.countIncreases(inputList));
    }

    @Test
    void TestCountIncreasesWithOneInput() {
        List<String> inputList = new ArrayList<>();
        inputList.add("1");

        SonarSweep sonar = new SonarSweep();
        assertEquals(0, sonar.countIncreases(inputList));
    }

    @Test
    void TestCountIncreasesWithEmpty() {
        List<String> inputList = new ArrayList<>();

        SonarSweep sonar = new SonarSweep();
        assertEquals(0, sonar.countIncreases(inputList));
    }

    @Test
    void TestcountThreeMeasurementIncreasesWithValidInput() {
        List<String> inputList = new ArrayList<>();
        inputList.add("199");
        inputList.add("200");
        inputList.add("208");
        inputList.add("210");
        inputList.add("200");
        inputList.add("207");
        inputList.add("240");
        inputList.add("269");
        inputList.add("260");
        inputList.add("263");

        SonarSweep sonar = new SonarSweep();
        assertEquals(5, sonar.countIncreasesSlidingWindow(inputList));
    }
}