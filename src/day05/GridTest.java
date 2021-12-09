package day05;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

class GridTest {
    @Test
    void testGridAddVerticalLine() {
        String lineInput = "1,1 -> 1,3";
        Line line = new Line(lineInput);

        Grid grid = new Grid(10, 10, false);

        assertTrue(grid.add(line));

        assertTrue(grid.isCovered(1, 1));
        assertTrue(grid.isCovered(1, 2));
        assertTrue(grid.isCovered(1, 3));
    }

    @Test
    void testGridAddVerticalLine2() {
        String lineInput = "1,3 -> 1,1";
        Line line = new Line(lineInput);

        Grid grid = new Grid(10, 10, false);

        assertTrue(grid.add(line));

        assertTrue(grid.isCovered(1, 1));
        assertTrue(grid.isCovered(1, 2));
        assertTrue(grid.isCovered(1, 3));
    }

    @Test
    void testGridAddHorizontalLine() {
        String lineInput = "1,1 -> 5,1";
        Line line = new Line(lineInput);

        Grid grid = new Grid(10, 10, false);

        assertTrue(grid.add(line));

        assertTrue(grid.isCovered(1, 1));
        assertTrue(grid.isCovered(2, 1));
        assertTrue(grid.isCovered(3, 1));
        assertTrue(grid.isCovered(4, 1));
        assertTrue(grid.isCovered(5, 1));
    }

    @Test
    void testGridAddHorizontalLine2() {
        String lineInput = "5,1 -> 2,1";
        Line line = new Line(lineInput);

        Grid grid = new Grid(10, 10, false);

        assertTrue(grid.add(line));

        assertTrue(grid.isCovered(2, 1));
        assertTrue(grid.isCovered(3, 1));
        assertTrue(grid.isCovered(4, 1));
        assertTrue(grid.isCovered(5, 1));
    }

    @Test
    void testGridIsCoveredUncoveredCoordinate() {
        String lineInput = "1,1 -> 5,1";
        Line line = new Line(lineInput);

        Grid grid = new Grid(10, 10, false);

        grid.add(line);

        assertTrue(grid.isCovered(1, 1));
        assertTrue(grid.isCovered(2, 1));
        assertTrue(grid.isCovered(3, 1));
        assertTrue(grid.isCovered(4, 1));
        assertTrue(grid.isCovered(5, 1));
        assertFalse(grid.isCovered(6, 1));
        assertFalse(grid.isCovered(0, 1));
        assertFalse(grid.isCovered(0, 0));
    }

    @Test
    void testGridAddDiagonalLine() {
        String lineInput = "1,1 -> 3,3";
        Line line = new Line(lineInput);

        Grid grid = new Grid(10, 10, true);

        assertTrue(grid.add(line));

        assertTrue(grid.isCovered(1, 1));
        assertTrue(grid.isCovered(2, 2));
        assertTrue(grid.isCovered(3, 3));
    }

    @Test
    void testGridAddDiagonalLine2() {
        String lineInput = "9,7 -> 7,9";
        Line line = new Line(lineInput);

        Grid grid = new Grid(10, 10, true);

        assertTrue(grid.add(line));

        assertTrue(grid.isCovered(9, 7));
        assertTrue(grid.isCovered(8, 8));
        assertTrue(grid.isCovered(7, 9));
    }

    @Test
    void testGetIntersectionsWithDiagonalLines() {
        List<String> lineCoordinates = new ArrayList<>();
        lineCoordinates.add("0,9 -> 5,9");
        lineCoordinates.add("8,0 -> 0,8");
        lineCoordinates.add("9,4 -> 3,4");
        lineCoordinates.add("2,2 -> 2,1");
        lineCoordinates.add("7,0 -> 7,4");
        lineCoordinates.add("6,4 -> 2,0");
        lineCoordinates.add("0,9 -> 2,9");
        lineCoordinates.add("3,4 -> 1,4");
        lineCoordinates.add("0,0 -> 8,8");
        lineCoordinates.add("5,5 -> 8,2");

        Grid grid = new Grid(10, 10, true);

        for(String coordinate : lineCoordinates) {
            Line line = new Line(coordinate);

            grid.add(line);
        }

        assertEquals(12, grid.getIntersections().size());
    }
}