// Subclass: InternationalShipment
// Extends Shipment and adds customs fee and destination country
class InternationalShipment extends Shipment {
    private double customsFee;
    private String destinationCountry;

    // Constructor
    public InternationalShipment(String trackingNumber, String sender, String receiver,
                                 double weight, double baseRate, double distanceKm,
                                 double customsFee, String destinationCountry) {
        super(trackingNumber, sender, receiver, weight, baseRate, distanceKm);
        this.customsFee = customsFee;
        this.destinationCountry = destinationCountry;
    }

    // Override calculateCost: add customs fee
    @Override
    public double calculateCost() {
        return super.calculateCost() + customsFee;
    }

    // Override getEstimatedDeliveryDays: slower + 2 days for customs
    @Override
    public int getEstimatedDeliveryDays() {
        return (int) Math.ceil(getDistanceKm() / 400.0) + 2;
    }

    // Extra method: check if customs declaration is needed
    public boolean requiresCustomsDeclaration() {
        return getWeight() > 2.0;
    }

    // Override getDetails: include customs info
    @Override
    public String getDetails() {
        return super.getDetails() +
                "\nCustoms Fee: " + customsFee +
                "\nDestination: " + destinationCountry;
    }
}
