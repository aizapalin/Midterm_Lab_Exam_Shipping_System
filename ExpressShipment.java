// Subclass: ExpressShipment
// Extends Shipment and adds priority levels with extra fees
class ExpressShipment extends Shipment {
    private String priorityLevel;
    private double priorityFee;

    // Constructor
    public ExpressShipment(String trackingNumber, String sender, String receiver,
                           double weight, double baseRate, double distanceKm,
                           String priorityLevel) {
        super(trackingNumber, sender, receiver, weight, baseRate, distanceKm);
        setPriorityLevel(priorityLevel);
    }

    // Set priority level and fee
    private void setPriorityLevel(String priorityLevel) {
        this.priorityLevel = priorityLevel;
        switch (priorityLevel) {
            case "High": this.priorityFee = 200; break;
            case "Rush": this.priorityFee = 500; break;
            default: this.priorityFee = 0; break; // Normal
        }
    }

    // Override calculateCost: add priority fee
    @Override
    public double calculateCost() {
        return super.calculateCost() + priorityFee;
    }

    // Extra method: check if high priority
    public boolean isHighPriority() {
        return priorityLevel.equals("High") || priorityLevel.equals("Rush");
    }

    // Override getDetails: include priority info
    @Override
    public String getDetails() {
        return super.getDetails() +
                "\nPriority Level: " + priorityLevel +
                "\nPriority Fee: " + priorityFee;
    }
}
