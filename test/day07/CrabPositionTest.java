package day07;

import org.junit.jupiter.api.Test;


import static org.junit.Assert.*;

class CrabPositionTest {
    @Test
    void testCrabPositionInit() {
        String input = "16,1,2,0,4,2,7,1,2,14";
        CrabPosition crabPosition = new CrabPosition(input);

        assertEquals(37, crabPosition.moveCrabsTo(2));
        assertEquals(41, crabPosition.moveCrabsTo(1));
        assertEquals(39, crabPosition.moveCrabsTo(3));
        assertEquals(71, crabPosition.moveCrabsTo(10));
    }

    @Test
    void testCrabPositionGetLeastFuel() {
        String input = "16,1,2,0,4,2,7,1,2,14";
        CrabPosition crabPosition = new CrabPosition(input);

        assertEquals(Integer.valueOf(37), crabPosition.getLeastFuel().getValue());
    }
}