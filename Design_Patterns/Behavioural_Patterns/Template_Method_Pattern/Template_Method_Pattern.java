package Design_Patterns.Behavioural_Patterns.Template_Method_Pattern;

abstract class Beverage{

    public void MakeBeverage(){
        boilWater();
        brewTheWater();
        pourInCup();
        addExtras();
    }

    public void boilWater(){
        System.out.println("Boiling the water");
    }

    public void pourInCup(){
        System.out.println("Pouring in the cup");
    }

    abstract public void brewTheWater();
    abstract public void addExtras();
    
}

class Tea extends Beverage{
    public void brewTheWater(){
        System.out.println("Adding tea leafs");
    }

    public void addExtras(){
        System.out.println("Adding lemon");
    }
}

class Coffee extends Beverage{
    public void brewTheWater(){
        System.out.println("Adding coffee powder");
    }

    public void addExtras(){
        System.out.println("Adding milk and sugar");
    }
}


class Main{
    public static void main(String[] args){
        Beverage tea=new Tea();
        tea.MakeBeverage();

        System.out.println();

        Beverage coffee=new Coffee();
        coffee.MakeBeverage();
    }
}
