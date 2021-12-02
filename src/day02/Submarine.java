package day02;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Submarine {

    private int horizontalPosition;
    private int depth;
    private int aim;

    public Submarine () {
        horizontalPosition = 0;
        depth = 0;
        aim = 0;
    }
    public void move(List<String> movements) {
        for(String movement : movements) {
            move(movement);
        }
    }

    public void move(String movement) {
        try {
            String[] tmp = movement.split(" ");
            String direction = tmp[0];
            int units = Integer.parseInt(tmp[1]);

            switch (direction) {
                case "forward" -> {
                    horizontalPosition += units;
                    depth += (aim * units);
                }
                case "up" -> aim -= units;
                case "down" -> aim += units;
            }
        } catch (Exception ignored) {

        }
    }

    public int getHorizontalPosition() {
        return horizontalPosition;
    }

    public int getDepth() {
        return depth;
    }

    public static void main(String[] args) throws IOException {
        List<String> inputList = new ArrayList<>();
        try (Stream<String> lines = Files.lines(Paths.get("input_day02.txt"), Charset.defaultCharset())) {
            lines.forEachOrdered(inputList::add);
        }

        Submarine submarine = new Submarine();
        submarine.move(inputList);

        System.out.println("Submarine Horizontal Position: " + submarine.getHorizontalPosition());
        System.out.println("Submarine Depth: " + submarine.getDepth());
        System.out.println("Product of Horizontal Position and Depth: " + submarine.getHorizontalPosition() * submarine.getDepth());
    }
}
