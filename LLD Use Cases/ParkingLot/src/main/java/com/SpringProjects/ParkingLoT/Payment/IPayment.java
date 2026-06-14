package com.SpringProjects.ParkingLoT.Payment;

import com.SpringProjects.ParkingLoT.Enums.EnumPaymentStatus;

public interface IPayment {
    public EnumPaymentStatus payBill(Double amount);
}
