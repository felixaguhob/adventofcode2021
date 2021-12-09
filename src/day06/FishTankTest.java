package day06;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

class FishTankTest {
    @Test
    void testFishTankRunSimulation() {
        String initialFish = "3,4,3,1,2";
        FishTank fishTank = new FishTank(initialFish);

        fishTank.runSimulation(2);
    }

    @Test
    void testFishTankRunSimulation18Days() {
        String initialFish = "3,4,3,1,2";
        FishTank fishTank = new FishTank(initialFish);

        fishTank.runSimulation(18);

        assertEquals(26, fishTank.getFishCount());
    }

    @Test
    void testFishTankRunSimulation80Days() {
        String initialFish = "3,4,3,1,2";
        FishTank fishTank = new FishTank(initialFish);

        fishTank.runSimulation(80);

        assertEquals(5934, fishTank.getFishCount());
    }

    @Test
    void testFishTankRunSimulation256Days() {
        String initialFish = "3,4,3,1,2";
        FishTank fishTank = new FishTank(initialFish);

        fishTank.runSimulation(256);

        assertEquals(26984457539L, fishTank.getFishCount());
    }
}