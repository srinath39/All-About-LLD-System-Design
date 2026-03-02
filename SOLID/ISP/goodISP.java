package ISP;

interface IChef{
    public void cook();
}
interface IWaiter{
    public void serve();
}

interface ICounter{
    public void registerBill();
}

class Chef implements IChef{
    public void cook(){
        System.out.print("I am cooking");
    }
}

class Waiter implements IWaiter{
    public void serve(){
        System.out.print("I am Serving");
    }
}

class Counter implements ICounter{
    public void registerBill(){
        System.out.print("Registering the bill");
    }
}
















