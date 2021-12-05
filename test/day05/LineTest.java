package day05;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

class LineTest {
    @Test

    void testCreateLine() {
        String lineInput = "0,9 -> 5,9";

        Line line = new Line(lineInput);

        assertEquals(0, line.getX1());
        assertEquals(9, line.getY1());
        assertEquals(5, line.getX2());
        assertEquals(9, line.getY1());
    }
}