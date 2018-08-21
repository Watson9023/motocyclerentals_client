package com.watson.motocyclerentals.services.impl;

import com.watson.motocyclerentals.domain.Rental;
import com.watson.motocyclerentals.repository.RentalRepository;
import com.watson.motocyclerentals.services.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Long on 4/24/2018.
 */
@Service
public class RentalImpl implements RentalService {
    @Autowired
    RentalRepository repository;
    public List<Rental> getRental() {
        List<Rental> allRentals = new ArrayList<Rental>();

        Iterable<Rental> rentals = repository.findAll();
        for (Rental rental : rentals) {
            allRentals.add(rental);
        }
        return allRentals;
    }
}

