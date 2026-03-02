package Srp;

class Chef {
    private int no_of_dishes_cooked;

    public void cookAnItem(String item){
        System.out.println(item+ " Item got Cooked");
        ++no_of_dishes_cooked;
    }

    public int getNoOfItemsCooked(){
        return no_of_dishes_cooked;
    }
}

class Waiter{
    private int no_of_dishes_served;
    public void serveItem(){
        --no_of_dishes_served;
    }

    public int getNoOfItemsServed(){
        return no_of_dishes_served;
    }
}
