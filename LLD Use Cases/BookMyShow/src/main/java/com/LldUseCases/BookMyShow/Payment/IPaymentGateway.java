package com.LldUseCases.BookMyShow.Payment;

import com.LldUseCases.BookMyShow.Enums.EnumPaymentStatus;

public interface IPaymentGateway {
    public EnumPaymentStatus payAmount(Double amount);
    public EnumPaymentStatus refundAmount(Double amount);
}
