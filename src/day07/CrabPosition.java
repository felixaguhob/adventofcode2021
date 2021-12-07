package day07;

import day06.FishTank;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class CrabPosition {

    ArrayList<Integer> crabs = new ArrayList<>();
    int maxCrabPos = 0;
    public CrabPosition(String crabs) {
        String[] crabsPositions = crabs.trim().split(",");
        for(String crabPos : crabsPositions) {
            this.crabs.add(Integer.parseInt(crabPos));
        }
        maxCrabPos = Collections.max(this.crabs);
    }

    public int moveCrabsTo(int position) {
        int totalFuelCost = 0;
        for (Integer crab : crabs) {
            totalFuelCost += Math.abs(position - crab);
        }


        return totalFuelCost;
    }

    public Map.Entry<Integer, Integer> getLeastFuel() {
        int leastFuel = Integer.MAX_VALUE;
        int pos = 0;
        for(int i=0; i <= maxCrabPos; i++) {
            int cost = moveCrabsTo(i);
            if (cost < leastFuel) {
                leastFuel = cost;
                pos = i;
            }
        }

        return new AbstractMap.SimpleEntry<>(pos, leastFuel);
    }

    public static void main(String[] args) throws IOException {
        String crabs = Files.readString(Paths.get("input_day07.txt"), StandardCharsets.US_ASCII);

        CrabPosition crabPosition = new CrabPosition(crabs);

        Map.Entry<Integer, Integer> result = crabPosition.getLeastFuel();
        System.out.println("Least Fuel Cost on Position: " + result.getKey() + " With Cost: "+ result.getValue());
    }
}
