import java.util.List;

public class ShippingService {
    public static void ship(List<Shipping> items , List<Integer> quantities) {
        if(items.isEmpty()) {
            throw new IllegalArgumentException("No items to ship.");
        }
        if (items.size() != quantities.size()) {
            throw new IllegalArgumentException("Items and quantities must have the same size.");
        }
        
        double totalWeight = 0;
       for (int i = 0; i < items.size(); i++) {
            Shipping item = items.get(i);
            int qty = quantities.get(i);
            double weight = item.getWeight() * qty;
            System.out.printf("Shipping %d x %s (%.2f kg)%n", qty, item.getName(), weight);
            totalWeight += weight;
        }
        
        System.out.println("Total weight of items to ship: " + totalWeight + " kg");
    }
}
