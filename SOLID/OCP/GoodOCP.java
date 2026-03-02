package OCP;

class PaymentServiceHelper {
    public void processThePay(PaymentService paymentType,double amount){
        paymentType.pay();
    }
}



interface PaymentService {
    public void pay();
}



class UpiMethod implements PaymentService{

    public void pay(){
        System.out.println("Paying using UPI");
    }
}


class NetBanking implements PaymentService{

    public void pay(){
        System.out.println("Paying using NetBanking");
    }
}


class CreditCard implements PaymentService{

    public void pay(){
        System.out.println("Paying using CreditCard");
    }
}


class BitCoin implements PaymentService{
    public void pay(){
        System.out.println("Paying using Bitcoin");
    }
}

class Main{
    public static void main(String[] args){
        PaymentServiceHelper paymentServiceHelper=new PaymentServiceHelper();
        paymentServiceHelper.processThePay(new BitCoin(), 100.0);
    }
}

