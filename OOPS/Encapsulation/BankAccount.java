package Encapsulation;

public class BankAccount {
    // Step 1: Make variables private
    private double balance;

    // Step 2: Public method to set value
    public void deposit(double amount) {   
        if (amount > 0) {                   // these methods does actions on the hidden Data
            balance += amount;              // And has Controll access, maintaining atommocity in doing  operations
        }
    }

    // Step 3: Public method to get value
    public double getBalance() {
        return balance;
    }
}
