package ridesharing;

public class Driver {
    private String driverId;
    private Point location;
    private boolean available;

    public Driver(String driverId, Point location) {
        this.driverId = driverId;
        this.location = location;
        this.available = true;
    }

    public String getDriverId() {
        return driverId;
    }

    public Point getLocation() {
        return location;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
