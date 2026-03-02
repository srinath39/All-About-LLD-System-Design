package Srp;

public class RestaurantBadSrp {
    private int no_of_dishes;

    public void cookAnItem(String item){
        System.out.println(item+ " Item got Cooked");
        ++no_of_dishes;
    }

    public int getNoOfItemsCooked(){
        return no_of_dishes;
    }


    public void serveItem(){
        --no_of_dishes;
    }

    public int getNoOfItemsServed(){
        return no_of_dishes;
    }

}
