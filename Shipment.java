// Base class: Shipment
// This class holds the common details and methods for all types of shipments
class Shipment {
    // Private attributes (encapsulation)
    private String trackingNumber;
    private String sender;
    private String receiver;
    private double weight;       // weight in kg
    private double baseRate;     // cost per kg
    private double distanceKm;   // shipping distance in km
    private boolean delivered;   // status

    // Constructor initializes shipment details
    public Shipment(String trackingNumber, String sender, String receiver,
                    double weight, double baseRate, double distanceKm) {
        this.trackingNumber = trackingNumber;
        this.sender = sender;
        this.receiver = receiver;
        setWeight(weight);        // use setter for validation
        setBaseRate(baseRate);
        setDistanceKm(distanceKm);
        this.delivered = false;   // default: not yet delivered
    }

    // Calculate basic cost = weight × base rate
    public double calculateCost() {
        return weight * baseRate;
    }

    // Mark shipment as delivered
    public void markDelivered() {
        delivered = true;
    }

    // Show if delivered or still in transit
    public String getDeliveryStatus() {
        return delivered ? "Delivered" : "In Transit";
    }

    // Estimated delivery days for standard (500 km/day by default)
    public int getEstimatedDeliveryDays() {
        return (int) Math.ceil(distanceKm / 500.0);
    }

    // Return formatted shipment details
    public String getDetails() {
        return "Tracking: " + trackingNumber +
                "\nSender: " + sender +
                "\nReceiver: " + receiver +
                "\nWeight: " + weight + " kg" +
                "\nBase Rate: " + baseRate +
                "\nDistance: " + distanceKm + " km" +
                "\nCost: " + calculateCost() +
                "\nStatus: " + getDeliveryStatus();
    }

    // Getters and Setters (with validation for positive values)
    public double getWeight() { return weight; }
    public void setWeight(double weight) {
        if (weight > 0) this.weight = weight;
        else this.weight = 1; // fallback to prevent errors
    }

    public double getBaseRate() { return baseRate; }
    public void setBaseRate(double baseRate) {
        if (baseRate > 0) this.baseRate = baseRate;
        else this.baseRate = 10; // fallback value
    }

    public double getDistanceKm() { return distanceKm; }
    public void setDistanceKm(double distanceKm) {
        if (distanceKm > 0) this.distanceKm = distanceKm;
        else this.distanceKm = 1; // fallback value
    }
}
