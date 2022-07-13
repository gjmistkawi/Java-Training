package Lesson_4.Problem_4;

public class Line {
    private int[] p1;
    private int[] p2;

    public Line(int[] p1, int[] p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public double getSlope() {
        return 1.0 * (p2[1] - p1[1]) / (p2[0] - p1[0]);
    }

    public double getDistance() {
        return Math.sqrt(1.0 * Math.pow(p2[0] - p1[0], 2) + Math.pow(p2[1] - p1[1], 2));
    }

    public boolean parrallelTo(Line other) {
        return (this.getSlope() == other.getSlope());
    }
}
