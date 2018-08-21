package com.watson.motocyclerentals.services.impl;

import com.watson.motocyclerentals.domain.Customer;
import com.watson.motocyclerentals.domain.Rental;
import com.watson.motocyclerentals.repository.CustomerRepository;
import com.watson.motocyclerentals.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Long on 4/24/2018.
 */
@Service
public class CustomerImpl implements CustomerService {
    @Autowired
    private CustomerRepository repository;

    //@Override
    public Customer findById(Long id) {
        return repository.findOne(id);
    }

    //@Override
    public Customer save(Customer entity) {
        return repository.save(entity);
    }

    //@Override
    public Customer update(Customer entity) {
        return repository.save(entity);
    }

   // @Override
    public void delete(Customer entity) {
        repository.delete(entity);

    }

    //@Override
    public List<Customer> findAll() {
        List<Customer> allcustomers = new ArrayList();
        Iterable<Customer> customers = repository.findAll();
        for (Customer customer : customers) {
            allcustomers.add(customer);
        }
        return allcustomers;
    }

    //@Override
    public List<Rental> getRental(Long id) {
        return repository.findOne(id).getRentals();
    }
}


/*
@Service
public class CustomerImpl implements CustomerService {
    @Autowired
    CustomerRepository repository;
    public List<Customer> getCustomer() {
        List<Customer> allCustomers = new ArrayList<Customer>();

        Iterable<Customer> customers = repository.findAll();
        for (Customer customer : customers) {
            allCustomers.add(customer);
        }
        return allCustomers;
    }

    @Override
    public List<Rental> getRental(Long id)
    {
        return repository.findOne(id).getRentals();
    }
}*/

