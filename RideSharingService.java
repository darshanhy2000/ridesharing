package ridesharing;

import java.util.HashMap;
import java.util.Map;



public class RideSharingService {
    private Map<String, Driver> drivers = new HashMap<>();
    private Map<String, Rider> riders = new HashMap<>();
    private Map<String, Ride> rides = new HashMap<>();

    public void addDriver(String driverId, Point location) {
        drivers.put(driverId, new Driver(driverId, location));
    }

    public void addRider(String riderId, Point location) {
        riders.put(riderId, new Rider(riderId, location));
    }

    public String findMatch(String riderId) {
        Rider rider = riders.get(riderId);
        if (rider == null) {
            return "Rider not found";
        }

        for (Driver driver : drivers.values()) {
            if (driver.isAvailable() && rider.getLocation().distanceTo(driver.getLocation()) <= 5) {
                driver.setAvailable(false);
                Ride ride = new Ride(rider, driver);
                rides.put(riderId, ride);
                return "Matched with driver " + driver.getDriverId();
            }
        }
        return "No drivers available within 5km range";
    }

    public String startRide(String riderId) {
        Ride ride = rides.get(riderId);
        if (ride == null) {
            return "No matching ride found";
        }
        return "Ride started with driver " + ride.getDriver().getDriverId();
    }

    public String completeRide(String riderId, Point endLocation) {
        Ride ride = rides.get(riderId);
        if (ride == null) {
            return "No ongoing ride found";
        }
        if (ride.getEndLocation() != null) {
            return "Ride already completed";
        }
        ride.completeRide(endLocation);
        
        return String.format(
            "Ride completed.\nStart location: %s\nEnd location: %s\nDistance: %.2f km\nTotal bill: ₹%.2f",
            ride.getStartLocation(),
            ride.getEndLocation(),
            ride.getDistance(),
            ride.getBill()
        );
    }

    public static void main(String[] args) {
        RideSharingService service = new RideSharingService();

        // Adding drivers
        service.addDriver("driver1", new Point(1, 1));
        service.addDriver("driver2", new Point(3, 3));

        // Adding a rider
        service.addRider("rider1", new Point(2, 2));

        // Finding a match
        System.out.println(service.findMatch("rider1"));  // Should match with driver1

        // Starting the ride
        System.out.println(service.startRide("rider1"));  // Should start the ride with driver1

        // Completing the ride
        Point endLocation = new Point(7, 7);
        System.out.println(service.completeRide("rider1", endLocation));  // Should calculate and display the bill
    }
}
