package day05;

import day03.PowerConsumptionReader;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Grid {
    private int horizontalLength;
    private int verticalLength;

    private int[][] gridMap;

    public Grid(int horizontalLength, int verticalLength) {
        this.horizontalLength = horizontalLength;
        this.verticalLength = verticalLength;

        gridMap = new int[horizontalLength][verticalLength];

        for(int x=0; x < horizontalLength; x++) {
            for(int y=0; y < horizontalLength; y++) {
                gridMap[x][y] = 0;
            }
        }
    }

    public boolean add(Line line) {
        if(line.getX1() == line.getX2()) {
            int x = line.getX1();
            int end = Math.max(line.getY1(), line.getY2());
            int start = Math.min(line.getY1(), line.getY2());
            for(int i=start; i <= end; i++) {
                gridMap[x][i] += 1;
            }
            return true;

        } else if(line.getY1() == line.getY2()) {
            int y = line.getY1();
            int end = Math.max(line.getX1(), line.getX2());
            int start = Math.min(line.getX1(), line.getX2());
            for(int i=start; i <= end; i++) {
                gridMap[i][y] += 1;
            }
            return true;
        } else {
            int steps = (Math.abs(line.getX1()  - line.getX2())) - 1;
            int count = 0;
            int curX = line.getX1();
            int curY = line.getY1();
            gridMap[curX][curY] += 1;

            while (count != steps) {
                if (line.getX1() > line.getX2()) {
                    curX -=1;
                } else {
                    curX +=1;
                }

                if (line.getY1() > line.getY2()) {
                    curY -=1;
                } else {
                    curY +=1;
                }
                gridMap[curX][curY] += 1;

                count++;
            }

            gridMap[line.getX2()][line.getY2()] += 1;
            return true;
        }
    }

    public boolean isCovered(int x, int y) {
        return gridMap[x][y] > 0;
    }

    public List<String> getIntersections() {
        List<String> intersections = new ArrayList<>();

        for(int x=0; x < horizontalLength; x++) {
            for(int y=0; y < horizontalLength; y++) {
                if (gridMap[x][y] > 1) {
                    intersections.add(x + "," + y);
                }
            }
        }

        return intersections;
    }

    public static void main(String[] args) throws IOException {
        List<String> inputList = new ArrayList<>();
        try (Stream<String> lines = Files.lines(Paths.get("input_day05.txt"), Charset.defaultCharset())) {
            lines.forEachOrdered(inputList::add);
        }

        Grid grid = new Grid(1000, 1000);

        for(String coordinate : inputList) {
            Line line = new Line(coordinate);

            grid.add(line);
        }

        System.out.println("Intersections Count: " + grid.getIntersections().size());
    }
}
