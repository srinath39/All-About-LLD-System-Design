package OCP;

class PaymentServiceHelper {
    // High prone to errors ( changing one logics disturbs other - leads to regression bugs)
    // Regression testing is needed 
    // Tightly coupled ( if any wrong goes with the class objects affects the method)
    // Voilates SRP principle ( Class method has multiple reason to change)
    // merge conflicts 
    // Less readability( too many if and else conditions)
    public void processThePay(Object paymentType,double amount){
        if(paymentType instanceof UpiMethod upi){
            upi.pay();
        }else if(paymentType instanceof CreditCard cc){
            cc.pay();
        }else if(paymentType instanceof NetBanking netBanking){
            netBanking.pay();
        }else if(paymentType instanceof BitCoin bitcoin){
            bitcoin.pay();
        }
    }
}



class UpiMethod{

    public void pay(){
        System.out.println("Paying using UPI");
    }
}


class NetBanking{

    public void pay(){
        System.out.println("Paying using NetBanking");
    }
}


class CreditCard{

    public void pay(){
        System.out.println("Paying using CreditCard");
    }
}

class BitCoin{
    public void pay(){
        System.out.println("Paying using Bitcoin");
    }
}


class Main{
    public static void main(String[] args){
        PaymentServiceHelper paymentServiceHelper=new PaymentServiceHelper();
        paymentServiceHelper.processThePay(new NetBanking(), 100.0);
    }
}