package com.watson.motocyclerentals.repository;

import com.watson.motocyclerentals.domain.Rental;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Long on 4/24/2018.
 */
public interface RentalRepository extends CrudRepository<Rental,Long> {
    Rental findOne(Long id);
}
