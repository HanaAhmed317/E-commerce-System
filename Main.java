import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
     
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        Date futureDate = cal.getTime();

        
        ExpirableShippable cheese = new ExpirableShippable(futureDate, "Cheese", 100, 5, 0.2);     // 200g
        ExpirableShippable biscuits = new ExpirableShippable(futureDate, "Biscuits", 150, 3, 0.7); // 700g
        Product scratchCard = new Product("Scratch Card", 50, 10); 

    
        Customer customer = new Customer("Hana", 1000);

    
        Cart cart = new Cart();
        cart.addItem(cheese, 2);       
        cart.addItem(biscuits, 1);      
        cart.addItem(scratchCard, 1);   

    
        CheckoutService.checkout(customer, cart);
    }
}

