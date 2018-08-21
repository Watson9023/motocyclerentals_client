package com.watson.motocyclerentals.services.Impl;

import com.watson.motocyclerentals.model.User;
import com.watson.motocyclerentals.repositories.rest.RestCustomerDetailsAPI;

/**
 *Created by Long on 2018/08/01.
 */
public class CustomerDetailsServiceImpl implements CustomerDetailsService  {
    final RestCustomerDetailsAPI rest = new RestCustomerDetailsAPI();

    @Override
    public String customer_details(User entity)
    {
        return rest.customer_details(entity);
    }
}
