import java.util.ArrayList;
import java.util.List;

class CheckoutService {
    static final double SHIPPING_FEE = 30.0;

    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("Error: Cart is empty");
            return;
        }

        double subtotal = 0;
        List<Shipping> shippableItems = new ArrayList<>();
        List<Integer> shippableQuantities = new ArrayList<>();

        // Normal for loop to iterate over cart items
        for (int i = 0; i < cart.items.size(); i++) {
            CartItem item = cart.items.get(i);

            // Check for stock and expiry
            if (item.quantity > item.product.quantity) {
                System.out.println("Error: Not enough stock for " + item.product.name);
                return;
            }
            if (item.product.isExpired()) {
                System.out.println("Error: " + item.product.name + " is expired");
                return;
            }
            subtotal += item.product.price * item.quantity;

            
            if (item.product instanceof Shipping) {
                shippableItems.add((Shipping) item.product);
                shippableQuantities.add(item.quantity);
            }
        }

     double shipping;
if (shippableItems.isEmpty()) {
    shipping = 0;
} else {
    shipping = SHIPPING_FEE;
}
        double total = subtotal + shipping;

        
        if (customer.balance < total) {
            System.out.println("Error: Insufficient balance");
            return;
        }
System.out.printf("Customer balance before payment: %.0f\n", customer.balance);
        
        for (int i = 0; i < cart.items.size(); i++) {
            CartItem item = cart.items.get(i);
            item.product.quantity -= item.quantity;
        }
        customer.balance -= total;

        
        ShippingService.ship(shippableItems, shippableQuantities);

    
        System.out.println("** Checkout receipt **");
        for (int i = 0; i < cart.items.size(); i++) {
            CartItem item = cart.items.get(i);
            System.out.printf("%dx %s\t%.0f\n", item.quantity, item.product.name, item.product.price * item.quantity);
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal\t%.0f\n", subtotal);
        System.out.printf("Shipping\t%.0f\n", shipping);
        System.out.printf("Amount\t\t%.0f\n", total);
        System.out.printf("Customer balance\t%.0f\n", customer.balance);
    }
}

   
