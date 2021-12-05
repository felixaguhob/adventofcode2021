package day05;

public class Line {

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Line(String lineEndpoints) {
        String[] endpoints = lineEndpoints.split(" -> ");
        x1 = Integer.parseInt(endpoints[0].trim().split(",")[0]);
        y1 = Integer.parseInt(endpoints[0].trim().split(",")[1]);
        x2 = Integer.parseInt(endpoints[1].trim().split(",")[0]);
        y2 = Integer.parseInt(endpoints[1].trim().split(",")[1]);
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }
}
