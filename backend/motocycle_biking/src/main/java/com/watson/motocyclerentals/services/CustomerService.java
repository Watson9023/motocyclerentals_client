package com.watson.motocyclerentals.services;

import com.watson.motocyclerentals.domain.Customer;
import com.watson.motocyclerentals.domain.Rental;

import java.util.List;

/**
 * Created by Long on 4/24/2018.
 */
public interface CustomerService extends Services<Customer,Long> {
        //List<Customer> getCustomer();
        List<Rental> getRental(Long id);
}
