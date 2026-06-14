package com.SpringProjects.ParkingLoT.Payment;

import com.SpringProjects.ParkingLoT.Enums.EnumPaymentStatus;

public class NetBankingPayment implements IPayment {
    @Override
    public EnumPaymentStatus payBill(Double amount) {
        if(amount==null){
            return EnumPaymentStatus.FAILED;
        }
        System.out.println("Paid bill by Net Banking of amount "+amount);
        return EnumPaymentStatus.SUCCESS;
    }
}
