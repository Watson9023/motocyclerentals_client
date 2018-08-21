package com.watson.motocyclerentals.domain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
/**
 * Created by Long on 4/24/2018.
 */


@RunWith(Suite.class)
@Suite.SuiteClasses({
        CustomerTest.class,
        MotorCycleTest.class,
        PaymentMethodTest.class,
        RentalTest.class,
        SalesPersonTest.class
})
public class TestSuite {
}
