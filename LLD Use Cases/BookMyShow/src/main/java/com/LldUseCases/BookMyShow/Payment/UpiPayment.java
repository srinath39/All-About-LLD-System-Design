package com.LldUseCases.BookMyShow.Payment;

import com.LldUseCases.BookMyShow.Enums.EnumPaymentStatus;

public class UpiPayment implements IPaymentGateway {

    @Override
    public EnumPaymentStatus payAmount(Double amount) {
        System.out.println("Total amount paid Using UPI is " + amount);
        return EnumPaymentStatus.SUCCESS;
    }

    @Override
    public EnumPaymentStatus refundAmount(Double amount) {
        System.out.println("Total amount refunded Using UPI is " + amount);
        return EnumPaymentStatus.SUCCESS;
    }
}
