package com.watson.motocyclerentals.services;

import com.watson.motocyclerentals.domain.MotorCycle;
import com.watson.motocyclerentals.domain.Rental;

import java.util.List;

/**
 * Created by Long on 4/24/2018.
 */
public interface MotorCycleService extends Services<MotorCycle,Long> {
    List<MotorCycle> getMotorCycles();
    List<Rental> getRental(Long id);
}
