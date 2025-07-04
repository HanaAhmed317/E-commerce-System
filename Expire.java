import java.util.Date;
public class Expire extends Product {
     public Date expirationDate;
    public Expire(Date expirationDate , String name ,double price, int quantity) {
        super(name, price, quantity);
        this.expirationDate = expirationDate;
    }
    @Override
    public boolean isExpired() {
        Date currentDate = new Date();
        return expirationDate.before(currentDate);
    }
}
