package Abstraction;

public class CreditCardPayment extends Payment {
    @Override  // there is already a implementation body in parent class, if not throw compile error 
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }
}
