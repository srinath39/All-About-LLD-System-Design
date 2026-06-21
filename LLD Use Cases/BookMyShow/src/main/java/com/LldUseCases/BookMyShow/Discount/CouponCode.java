package com.LldUseCases.BookMyShow.Discount;

public class CouponCode implements IDiscountCoupon{
    public Double applyDiscoun(Double amount){
        return amount*0.25;
    }
}
