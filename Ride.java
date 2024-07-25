package ridesharing;

public class Ride {
    private Rider rider;
    private Driver driver;
    private Point startLocation;
    private Point endLocation;
    private double distance;
    private double bill;

    public Ride(Rider rider, Driver driver) {
        this.rider = rider;
        this.driver = driver;
        this.startLocation = rider.getLocation();
    }

    public void completeRide(Point endLocation) {
        this.endLocation = endLocation;
        this.distance = startLocation.distanceTo(endLocation);
        double ratePerKm = 20;  // Assuming ₹20 per km
        this.bill = Math.round(this.distance * ratePerKm * 100.0) / 100.0;
        this.driver.setAvailable(true);
    }

    public double getBill() {
        return bill;
    }

    public Rider getRider() {
        return rider;
    }

    public Driver getDriver() {
        return driver;
    }

    public Point getStartLocation() {
        return startLocation;
    }

    public Point getEndLocation() {
        return endLocation;
    }
    
    public double getDistance() {
        return distance;
    }
}
