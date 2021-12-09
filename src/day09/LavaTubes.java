package day09;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class LavaTubes {

    public class Point {
        public int x;
        public int y;
        public int heightValue;

        public Point(int x, int y, int heightValue) {
            this.x = x;
            this.y = y;
            this.heightValue = heightValue;
        }
    }

    private int[][] heightGrid;
    private int maxGridLength;
    private int maxGridWidth;

    public LavaTubes(List<String> tubeHeights) {
        int gridMaxLength = tubeHeights.get(0).length();
        int gridMaxWidth = tubeHeights.size();

        heightGrid = new int[gridMaxLength][gridMaxWidth];
        maxGridLength = gridMaxLength;
        maxGridWidth = gridMaxWidth;

        int y=0;
        for(String tubes : tubeHeights) {
            for(int x=0; x < tubes.length(); x++) {
                heightGrid[x][y] = Character.getNumericValue(tubes.charAt(x));
            }
            y++;
        }
    }

    public int getHeightAt(int x, int y) {
        return heightGrid[x][y];
    }

    private Point getTop(int x, int y) {
        int newY = y - 1;
        if ((x >= 0) && (x < maxGridLength) &&
                (newY >= 0) && (newY < maxGridWidth)) {
            return new Point(x, newY, heightGrid[x][newY]);
        }
        return new Point(x, newY, Integer.MAX_VALUE);
    }

    private Point getBottom(int x, int y) {
        int newY = y + 1;
        if ((x >= 0) && (x < maxGridLength) &&
                (newY >= 0) && (newY < maxGridWidth)) {
            return new Point(x, newY, heightGrid[x][newY]);
        }
        return new Point(x, newY, Integer.MAX_VALUE);
    }

    private Point getLeft(int x, int y) {
        int newX = x - 1;
        if ((newX >= 0) && (newX < maxGridLength) &&
                (y >= 0) && (y < maxGridWidth)) {
            return new Point(newX, y, heightGrid[newX][y]);
        }
        return new Point(newX, y, Integer.MAX_VALUE);
    }

    private Point getRight(int x, int y) {
        int newX = x + 1;
        if ((newX >= 0) && (newX < maxGridLength) &&
                (y >= 0) && (y < maxGridWidth)) {
            return new Point(newX, y, heightGrid[newX][y]);
        }
        return new Point(newX, y, Integer.MAX_VALUE);
    }

    public List<Point> getLowPoints() {
        List<Point> result = new ArrayList<>();
        for(int y=0; y < maxGridWidth; y++) {
            for(int x=0; x < maxGridLength; x++) {
                Point top = getTop(x, y);
                Point bottom = getBottom(x, y);
                Point left = getLeft(x, y);
                Point right = getRight(x, y);
                int cur = heightGrid[x][y];

                if ((cur < top.heightValue) && (cur < bottom.heightValue) &&
                    (cur < left.heightValue) && (cur < right.heightValue)) {
                    Point point = new Point(x, y, cur);
                    result.add(point);
                }
            }
        }

        return result;
    }

    public int getSumOfRiskLevels() {
        int totalRiskLevels = 0;
        List<Point> points = getLowPoints();
        for(Point lp : points) {
            totalRiskLevels += lp.heightValue + 1;
        }

        return totalRiskLevels;
    }

    public Set<Point> getBasinAt(int x, int y) {
        Set<Point> partOfBasin = new HashSet<>();
        if (heightGrid[x][y] <= 8) {
            partOfBasin.add(new Point(x, y, heightGrid[x][y]));
        }

        searchGrid(x, y, partOfBasin);
        return partOfBasin;
    }

    private void searchGrid(int x, int y, Set<Point> partOfBasin) {
        Point top = getTop(x, y);
        Point bottom = getBottom(x, y);
        Point left = getLeft(x, y);
        Point right = getRight(x, y);

        if ((top.heightValue <= 8) && !contains(partOfBasin, top)){
            partOfBasin.add(top);
            searchGrid(top.x, top.y, partOfBasin);
        }

        if ((bottom.heightValue <= 8) && !contains(partOfBasin, bottom)){
            partOfBasin.add(bottom);
            searchGrid(bottom.x, bottom.y, partOfBasin);
        }

        if ((left.heightValue <= 8) && !contains(partOfBasin, left)){
            partOfBasin.add(left);
            searchGrid(left.x, left.y, partOfBasin);
        }

        if ((right.heightValue <= 8) &&  !contains(partOfBasin, right)){
            partOfBasin.add(right);
            searchGrid(right.x, right.y, partOfBasin);
        }
    }

    private boolean contains(Set<Point> haystack, Point needle) {
        for(Point hay : haystack) {
            if((hay.x == needle.x) && (hay.y == needle.y)) {
                return true;
            }
        }
        return false;
    }


    public int getThreeLargestBasinsProduct() {
        List<Point> points = getLowPoints();
        List<Integer> basinSizes = new ArrayList<>();
        for(Point point : points) {
            Set<Point> basin = getBasinAt(point.x, point.y);
            basinSizes.add(basin.size());
        }

        Collections.sort(basinSizes);

        return basinSizes.get(basinSizes.size()-1) * basinSizes.get(basinSizes.size()-2) * basinSizes.get(basinSizes.size()-3);
    }

    public static void main(String[] args) throws IOException {
        List<String> inputList = new ArrayList<>();
        try (Stream<String> lines = Files.lines(Paths.get("src/day09/input.txt"), Charset.defaultCharset())) {
            lines.forEachOrdered(inputList::add);
        }

        LavaTubes lavaTubes = new LavaTubes(inputList);

        System.out.println("Sum of risk levels for all low points : " + lavaTubes.getSumOfRiskLevels());
        System.out.println("Product of the sizes of 3 larges basins : " + lavaTubes.getThreeLargestBasinsProduct());
    }
}
