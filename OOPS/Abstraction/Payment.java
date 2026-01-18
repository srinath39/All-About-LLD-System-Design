package Abstraction;

abstract public class Payment {
    abstract public void pay(int amount);  // WHAT to do

    public void printReceipt() {
        System.out.println("Payment successful");
    }
}




