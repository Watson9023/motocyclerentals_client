package com.watson.motocyclerentals.repository;

import com.watson.motocyclerentals.domain.PaymentMethod;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Long on 4/24/2018.
 */
public interface PaymentMethodRepository extends CrudRepository<PaymentMethod,Long> {
}
