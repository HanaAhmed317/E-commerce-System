import java.util.Date;

public class ExpirableShippable extends Expire implements Shipping {
    private double weight;

    public ExpirableShippable(Date expirationDate, String name, double price, int quantity, double weight) {
        super(expirationDate, name, price, quantity); 
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String getName() {
        return name;
    }
}
