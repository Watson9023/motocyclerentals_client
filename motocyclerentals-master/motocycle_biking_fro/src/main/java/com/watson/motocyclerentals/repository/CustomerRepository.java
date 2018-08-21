package com.watson.motocyclerentals.repository;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.watson.motocyclerentals.domain.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Long on 6/29/2018.
 */
@JsonDeserialize(as = Customer.class)
public interface CustomerRepository extends CrudRepository<Customer,Long> {
}
