package ridesharing;

public class Rider {
    private String riderId;
    private Point location;

    public Rider(String riderId, Point location) {
        this.riderId = riderId;
        this.location = location;
    }

    public String getRiderId() {
        return riderId;
    }

    public Point getLocation() {
        return location;
    }
}
