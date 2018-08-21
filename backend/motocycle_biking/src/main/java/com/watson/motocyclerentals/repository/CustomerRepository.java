package com.watson.motocyclerentals.repository;

import com.watson.motocyclerentals.domain.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Long on 4/24/2018.
 */
public interface CustomerRepository extends CrudRepository<Customer,Long> {
    Customer findOne(Long id);
}
