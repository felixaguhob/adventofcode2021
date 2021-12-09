package day09;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

class LavaTubesTest {
    @Test
    void testLavaTubesInit() {
        List<String> tubes = new ArrayList<>();
        tubes.add("2199943210");
        tubes.add("3987894921");
        tubes.add("9856789892");
        tubes.add("8767896789");
        tubes.add("9899965678");

        LavaTubes lavaTubes = new LavaTubes(tubes);

        assertEquals(5, lavaTubes.getHeightAt(2, 2));
        assertEquals(2, lavaTubes.getHeightAt(0, 0));
    }

    @Test
    void testLavaTubesGetLowPoints() {
        List<String> tubes = new ArrayList<>();
        tubes.add("2199943210");
        tubes.add("3987894921");
        tubes.add("9856789892");
        tubes.add("8767896789");
        tubes.add("9899965678");

        LavaTubes lavaTubes = new LavaTubes(tubes);

        assertEquals(4, lavaTubes.getLowPoints().size());
        assertEquals(1, lavaTubes.getLowPoints().get(0).heightValue);
        assertEquals(0, lavaTubes.getLowPoints().get(1).heightValue);
        assertEquals(5, lavaTubes.getLowPoints().get(2).heightValue);
        assertEquals(5, lavaTubes.getLowPoints().get(3).heightValue);
    }

    @Test
    void testLavaTubesGetSumOfRiskLevels() {
        List<String> tubes = new ArrayList<>();
        tubes.add("2199943210");
        tubes.add("3987894921");
        tubes.add("9856789892");
        tubes.add("8767896789");
        tubes.add("9899965678");

        LavaTubes lavaTubes = new LavaTubes(tubes);

        assertEquals(15, lavaTubes.getSumOfRiskLevels());
    }

    @Test
    void testGetBasinAtReturnCorrectSizes() {
        List<String> tubes = new ArrayList<>();
        tubes.add("2199943210");
        tubes.add("3987894921");
        tubes.add("9856789892");
        tubes.add("8767896789");
        tubes.add("9899965678");

        LavaTubes lavaTubes = new LavaTubes(tubes);

        assertEquals(3, lavaTubes.getBasinAt(1, 0).size());
        assertEquals(9, lavaTubes.getBasinAt(9, 0).size());
        assertEquals(14, lavaTubes.getBasinAt(2, 2).size());
        assertEquals(9, lavaTubes.getBasinAt(6, 4).size());
    }

    @Test
    void testGetProductForThreeLargestBasins() {
        List<String> tubes = new ArrayList<>();
        tubes.add("2199943210");
        tubes.add("3987894921");
        tubes.add("9856789892");
        tubes.add("8767896789");
        tubes.add("9899965678");

        LavaTubes lavaTubes = new LavaTubes(tubes);

        assertEquals(1134, lavaTubes.getThreeLargestBasinsProduct());
    }
}