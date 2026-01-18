package Abstraction;
public class UpiPayment extends Payment {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using UPI");
    }
}
