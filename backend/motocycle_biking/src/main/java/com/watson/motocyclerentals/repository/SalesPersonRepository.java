package com.watson.motocyclerentals.repository;

import com.watson.motocyclerentals.domain.SalesPerson;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Long on 4/24/2018.
 */
public interface SalesPersonRepository extends CrudRepository<SalesPerson,Long> {
    SalesPerson findOne(Long id);
}
