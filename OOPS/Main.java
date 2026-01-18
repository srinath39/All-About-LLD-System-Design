import Encapsulation.BankAccount;
import Inheritance.*;
import Polymorphism.*;
import Abstraction.*;

// only one public class is allowed in Java, and that should match the file name 
// i can have a OUR_OWN_NAME.java file with classes without public , but these classes cannot be accessible outside package because they are default.
public class Main {
    public static void main(String[] args) {

        // Encapsulation
        BankAccount b=new BankAccount();
        b.deposit(200.0);
        System.out.println(b.getBalance());

        // Inheritance (Single)
        AdvanceHuman advanceHuman = new AdvanceHuman();
        advanceHuman.hunting();
        advanceHuman.eating();

        // Inheritance ( Multi-level)
        Dog dog=new Dog();
        dog.breathe();
        dog.eat();
        dog.bark();

        // Abstraction Through Abstract Keyword
        Payment payment = new UpiPayment();
        payment.pay(500);
        payment.printReceipt();

        // Abstraction Using Interface
        Vehicle v = new Car();
        v.start();
        v.stop();

        // Polymorphism
        Animal a;

        a = new Cow();
        a.sound(); // cow sounds 

        a = new Cat();
        a.sound(); // Cat meows

    }
}