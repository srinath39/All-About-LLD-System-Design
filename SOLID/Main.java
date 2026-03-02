import Srp.RestaurantBadSrp;
public class Main {
     public static void main(){

        // Without SRP Principle
        // Serving Multiple Actors 
        // serve action disturbs the cook action 
        RestaurantBadSrp restaurant=new RestaurantBadSrp();
        restaurant.cookAnItem("maggie");
        restaurant.cookAnItem("Chicken");
        restaurant.cookAnItem("Dosa");
        restaurant.cookAnItem("Fish Curry");

        restaurant.serveItem();
        System.out.println(restaurant.getNoOfItemsCooked());   // 3





    }
}
