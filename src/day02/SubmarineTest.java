package day02;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubmarineTest {

    @Test
    void TestSubmarine() {
        Submarine submarine = new Submarine();

        assertEquals(0, submarine.getHorizontalPosition());
        assertEquals(0, submarine.getDepth());
    }

    @Test
    void TestSubmarineMoveForward() {
        Submarine submarine = new Submarine();

        String movement = "forward 5";

        submarine.move(movement);

        assertEquals(5, submarine.getHorizontalPosition());
        assertEquals(0, submarine.getDepth());
    }

    @Test
    void TestSubmarineMoveInvalidDirection() {
        Submarine submarine = new Submarine();

        String movement = "towards 5";

        submarine.move(movement);

        assertEquals(0, submarine.getHorizontalPosition());
    }

    @Test
    void TestSubmarineMoveForwardInvalidUnits() {
        Submarine submarine = new Submarine();

        String movement = "forward five";

        submarine.move(movement);

        assertEquals(0, submarine.getHorizontalPosition());
    }

    @Test
    void TestSubmarineMoveUp() {
        Submarine submarine = new Submarine();

        String movement = "up 5";

        submarine.move(movement);

        assertEquals(-5, submarine.getDepth());
    }

    @Test
    void TestSubmarineMoveUpInvalidUnits() {
        Submarine submarine = new Submarine();

        String movement = "up five";

        submarine.move(movement);

        assertEquals(0, submarine.getDepth());
    }

    @Test
    void TestSubmarineMoveDown() {
        Submarine submarine = new Submarine();

        String movement = "down 5";

        submarine.move(movement);

        assertEquals(5, submarine.getDepth());
    }

    @Test
    void TestSubmarineMoveDownInvalidUnits() {
        Submarine submarine = new Submarine();

        String movement = "down five";

        submarine.move(movement);

        assertEquals(0, submarine.getDepth());
    }

    @Test
    void TestSubmarineListOfMovements() {
        List<String> movements = new ArrayList<>();
        movements.add("forward 5");
        movements.add("down 5");
        movements.add("forward 8");
        movements.add("up 3");
        movements.add("down 8");
        movements.add("forward 2");

        Submarine submarine = new Submarine();

        submarine.move(movements);

        assertEquals(15, submarine.getHorizontalPosition());
        assertEquals(10, submarine.getDepth());
    }

    @Test
    void TestSubmarineMoveWithAimForward() {
        Submarine submarine = new Submarine();

        String movement = "forward 5";

        submarine.moveWithAim(movement);

        assertEquals(5, submarine.getHorizontalPosition());
        assertEquals(0, submarine.getDepth());
    }


    @Test
    void TestSubmarineMoveWithAimDown() {
        Submarine submarine = new Submarine();

        String movement = "down 5";

        submarine.moveWithAim(movement);

        assertEquals(0, submarine.getDepth());
    }

    @Test
    void TestSubmarineListOfMovementsWithAim() {
        List<String> movements = new ArrayList<>();
        movements.add("forward 5");
        movements.add("down 5");
        movements.add("forward 8");
        movements.add("up 3");
        movements.add("down 8");
        movements.add("forward 2");

        Submarine submarine = new Submarine();

        submarine.moveWithAim(movements);

        assertEquals(15, submarine.getHorizontalPosition());
        assertEquals(60, submarine.getDepth());
    }
}
