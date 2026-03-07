package Design_Patterns.Structural_Patterns.AdapterPattern;


// Client Code 
class PaymentHelper {
    public void makePayment(IPayment payment){
        payment.pay();
    }
}

interface IPayment{
    public void pay();
}

class CreditCard implements IPayment{
    public void pay(){
        System.out.println("Paying using credit card");
    }
}

class Netbanking implements IPayment{
    public void pay(){
        System.out.println("Paying using Netbanking");
    }
}

// Third party payment service  ( Adaptee)
// we only know what class name is , and the method it offers
class RazorPay{
    public void registerPayment(){
        // we don't know the implementation 
        System.out.println("Paying using Razor Pay");
    }
}


// Adapter
class PaymentAdapter implements IPayment{
    private RazorPay razorPay;
    public PaymentAdapter(RazorPay razorPay){
        this.razorPay=razorPay;
    }
    public void pay(){
        razorPay.registerPayment();
    } 
}

class Main{
    public static void main(String[] args){
        IPayment payment=new PaymentAdapter(new RazorPay());
        PaymentHelper paymentHelper=new PaymentHelper();
        paymentHelper.makePayment(payment);
    }
}