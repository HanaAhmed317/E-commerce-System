import java.util.ArrayList;
import java.util.List;
public class Cart {
     List<CartItem> items= new ArrayList<>();
    public void addItem(Product product, int quantity) { 
      if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }
        if (quantity > product.quantity) {
            throw new IllegalArgumentException("Not enough stock available.");
        }
        if (product.isExpired()) {
            throw new IllegalArgumentException("Cannot add expired product to cart.");
        }
     for(int i = 0; i < items.size(); i++) {
            CartItem item = items.get(i);
            if (item.product.name.equals(product.name)) {
                item.quantity += quantity;
                return;
            }
        }
      items.add(new CartItem(product, quantity));

    }

    public void remove(Product product) {
        for (int i = 0; i < items.size(); i++) {
            CartItem item = items.get(i);
            if (item.product == product) {
                items.remove(i);
                i--; 
            }
        }
    }
public boolean isEmpty() {
        return items.isEmpty();
    }
}
