package com.SpringProjects.ParkingLoT.Payment;

import com.SpringProjects.ParkingLoT.Enums.EnumPaymentStatus;

public class UpiPayment implements IPayment{
    @Override
    public EnumPaymentStatus payBill(Double amount) {
        if(amount==null){
            return EnumPaymentStatus.FAILED;
        }
        System.out.println("Paid bill by UPI of amount "+amount);
        return EnumPaymentStatus.SUCCESS;
    }
}
