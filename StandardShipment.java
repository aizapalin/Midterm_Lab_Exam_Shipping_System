// Subclass: StandardShipment
// Extends Shipment and adds an insurance fee
class StandardShipment extends Shipment {
    private double insuranceFee;

    // Constructor
    public StandardShipment(String trackingNumber, String sender, String receiver,
                            double weight, double baseRate, double distanceKm,
                            double insuranceFee) {
        super(trackingNumber, sender, receiver, weight, baseRate, distanceKm);
        this.insuranceFee = insuranceFee;
    }

    // Override calculateCost: add insurance fee
    @Override
    public double calculateCost() {
        return super.calculateCost() + insuranceFee;
    }

    // Override getDetails: include insurance fee
    @Override
    public String getDetails() {
        return super.getDetails() +
                "\nInsurance Fee: " + insuranceFee;
    }
}
