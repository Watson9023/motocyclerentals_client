package com.watson.motocyclerentals.services;

import com.watson.motocyclerentals.domain.Customer;
import com.watson.motocyclerentals.domain.SalesPerson;

import java.util.List;

/**
 * Created by Long on 4/24/2018.
 */
public interface SalesPersonService extends Services<SalesPerson,Long>{
    //List<SalesPerson> getSalesPerson();
    List<Customer> getCustomers(Long id);
}
