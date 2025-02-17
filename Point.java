package ridesharing;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Point other) {
        return Math.round(Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2)) * 100.0) / 100.0;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
