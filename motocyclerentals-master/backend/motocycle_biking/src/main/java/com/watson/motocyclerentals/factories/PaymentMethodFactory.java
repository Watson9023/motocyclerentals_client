package com.watson.motocyclerentals.factories;

import com.watson.motocyclerentals.domain.PaymentMethod;

/**
 * Created by Long on 4/24/2018.
 */
public class PaymentMethodFactory {
    public static PaymentMethod createPaymentMethod(String PaymentType, double Price)
    {
        PaymentMethod paymentMethod = new PaymentMethod
                .Builder(PaymentType)
                .Price(Price)
                .build();
        return paymentMethod;
    }
}
