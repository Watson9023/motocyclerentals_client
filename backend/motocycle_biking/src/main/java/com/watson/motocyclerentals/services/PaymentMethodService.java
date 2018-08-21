package com.watson.motocyclerentals.services;

import com.watson.motocyclerentals.domain.PaymentMethod;

import java.util.List;

/**
 * Created by Long on 4/24/2018.
 */
public interface PaymentMethodService {
    List<PaymentMethod> getPaymentMethod();
}
