// Main class: ShippingSystemTest
// This program prints each shipment individually (before & after delivery)

public class ShippingSystemTest {
    public static void main(String[] args) {
        // === Standard Shipment Example ===
        StandardShipment standard = new StandardShipment(
                "STD001", "Aliyah", "Glessly", 10, 30, 900, 100);

        // === Express Shipment Example ===
        ExpressShipment express = new ExpressShipment(
                "EXP001", "Justin", "Jacob", 5, 50, 1600, "Rush");

        // === International Shipment Example ===
        InternationalShipment intl = new InternationalShipment(
                "INT001", "Adrianne", "Aiza", 3, 40, 2000, 300, "Japan");

        // === STANDARD SHIPMENT ===
        System.out.println("\n=== STANDARD SHIPMENT ===");
        System.out.println("--- BEFORE Delivery ---");
        System.out.println(standard.getDetails());
        System.out.println("Estimated Days: " + standard.getEstimatedDeliveryDays());
        System.out.println("Status: " + standard.getDeliveryStatus());

        standard.markDelivered();
        System.out.println("\n--- AFTER Delivery ---");
        System.out.println("Status: " + standard.getDeliveryStatus());

        // === EXPRESS SHIPMENT ===
        System.out.println("\n=== EXPRESS SHIPMENT ===");
        System.out.println("--- BEFORE Delivery ---");
        System.out.println(express.getDetails());
        System.out.println("Estimated Days: " + express.getEstimatedDeliveryDays());
        System.out.println("High Priority? " + express.isHighPriority());
        System.out.println("Status: " + express.getDeliveryStatus());

        express.markDelivered();
        System.out.println("\n--- AFTER Delivery ---");
        System.out.println("Status: " + express.getDeliveryStatus());

        // === INTERNATIONAL SHIPMENT ===
        System.out.println("\n=== INTERNATIONAL SHIPMENT ===");
        System.out.println("--- BEFORE Delivery ---");
        System.out.println(intl.getDetails());
        System.out.println("Estimated Days: " + intl.getEstimatedDeliveryDays());
        System.out.println("Requires Customs Declaration? " + intl.requiresCustomsDeclaration());
        System.out.println("Status: " + intl.getDeliveryStatus());

        intl.markDelivered();
        System.out.println("\n--- AFTER Delivery ---");
        System.out.println("Status: " + intl.getDeliveryStatus());
    }
}
