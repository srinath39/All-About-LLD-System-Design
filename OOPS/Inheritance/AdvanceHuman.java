package Inheritance;
 class Human{
    private int age;
    private double height;
    private double weight;

    public void eating(){
        System.out.println("eating..");
    }

    public void sleeping(){
        System.out.println("Sleeping..");
    }

    public void hunting(){
        System.out.println("Hunting..");
    }
}


public class AdvanceHuman extends Human{
    public void talking(){
        System.out.println("Talking..");
    }
}