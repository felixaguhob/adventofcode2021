package day06;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FishTank {

    private long[] groupFishes = new long[9];
    public FishTank(String initialFishes) {
        String[] fishTimers = initialFishes.split(",");

        for(String fishTimer : fishTimers) {
            groupFishes[Integer.parseInt(fishTimer)] += 1;
        }
    }

    public long getFishCount() {
        long count = 0l;
        for(long group : groupFishes) {
            count += group;
        }

        return count;
    }

    public void runSimulation(int days) {
        for (int i=1; i <= days; i++) {
            long pregnantFishes = groupFishes[0];
            for(int j=0; j <= groupFishes.length - 2; j++) {
                groupFishes[j] = groupFishes[j + 1];
            }
            groupFishes[6] += pregnantFishes; //mommy fishies
            groupFishes[8] = pregnantFishes; //offspring fishies
        }
    }

    public static void main(String[] args) throws IOException {
        String drawNumbers = Files.readString(Paths.get("src/day06/input_day06.txt"), StandardCharsets.US_ASCII);

        FishTank fishTank = new FishTank(drawNumbers);
        fishTank.runSimulation(80);
        System.out.println("Total Fish in Tank After 80 Days: " + fishTank.getFishCount());

        FishTank fishTank2 = new FishTank(drawNumbers);
        fishTank2.runSimulation(256);
        System.out.println("Total Fish in Tank After 256 Days: " + fishTank2.getFishCount());
    }
}
