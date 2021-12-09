package day07;

import org.junit.jupiter.api.Test;


import static org.junit.Assert.*;

class CrabSubmarinesTest {
    @Test
    void testCrabSubmarineInit() {
        String input = "16,1,2,0,4,2,7,1,2,14";
        CrabSubmarines crabSubmarines = new CrabSubmarines(input);

        assertEquals(37, crabSubmarines.moveCrabsTo(2));
        assertEquals(41, crabSubmarines.moveCrabsTo(1));
        assertEquals(39, crabSubmarines.moveCrabsTo(3));
        assertEquals(71, crabSubmarines.moveCrabsTo(10));
    }

    @Test
    void testCrabSubmarineGetLeastFuel() {
        String input = "16,1,2,0,4,2,7,1,2,14";
        CrabSubmarines crabSubmarines = new CrabSubmarines(input);

        assertEquals(Integer.valueOf(37), crabSubmarines.getLeastFuel().getValue());
    }

    @Test
    void testCrabSubmarineMoveCrabExponential() {
        String input = "16,1,2,0,4,2,7,1,2,14";
        CrabSubmarines crabSubmarines = new CrabSubmarines(input);

        assertEquals(168, crabSubmarines.moveCrabsToExponential(5));
        assertEquals(206, crabSubmarines.moveCrabsToExponential(2));
    }

    @Test
    void testCrabSubmarineGetLeastFuelExponential() {
        String input = "16,1,2,0,4,2,7,1,2,14";
        CrabSubmarines crabSubmarines = new CrabSubmarines(input);

        assertEquals(Integer.valueOf(168), crabSubmarines.getLeastFuelExponential().getValue());
    }
}