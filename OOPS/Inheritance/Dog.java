package Inheritance;

class LivingBeing {
    public void breathe() {
        System.out.println("Breathing");
    }
}

class Animal extends LivingBeing {
    public void eat() {
        System.out.println("Eating");
    }
}

public class Dog extends Animal {
    public void bark() {
        System.out.println("Barking");
    }
}




