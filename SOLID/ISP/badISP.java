package ISP;

// This interface is called Fat interface, forcing the class to implement the methods  which it is
// not intend to
interface IRestaurant{
    public void cook();
    public void serve();
    public void registerBill();
}

class Chef implements IRestaurant{
    public void cook(){
        System.out.print("I am cooking");
    }

    public void serve(){
        // forced imp
    }

    public void registerBill(){
        // forced imp
    }
}
