package com.watson.motocyclerentals.factories;

import com.watson.motocyclerentals.domain.Customer;
import com.watson.motocyclerentals.domain.Rental;

import java.util.List;

/**
 * Created by Long on 4/24/2018.
 */
public class CustomerFactory {
    public static Customer createCustomer(String firstName, String lastName, String phoneNumber, String Address, String City, String postalCode, String username, String password, List<Rental> rentals)
    {
        Customer customer = new Customer
                .Builder(lastName)
                .firstName(firstName)
                .phoneNumber(phoneNumber)
                .addressEmbeddable(AddressEmbeddableFactory.createAddress(Address, City, postalCode))
                .loginEmbeddable(LoginEmbeddableFactory.createLogin(username, password))
                .rentals(rentals)
                .build();
        return customer;
    }
}
