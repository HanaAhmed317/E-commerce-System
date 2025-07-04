public class Product {
     public String name;
    public  double price;
    int quantity;

    // constructor
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public boolean isExpired() {
        return false;
    }
}
interface Shipping {
    double getWeight();
    String getName();
}