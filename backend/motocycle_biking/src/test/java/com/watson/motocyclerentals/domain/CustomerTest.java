package com.watson.motocyclerentals.domain;
import com.watson.motocyclerentals.factories.CustomerFactory;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;


/**
 * Created by Long on 4/24/2018.
 */
public class CustomerTest {
    @Before
    public void setUp() throws Exception
    {

    }

    @Test
    public void testCreateAdmin() throws Exception
    {
        Customer customer = CustomerFactory.createCustomer("Lina", "Doe", "0821298252", "307 Beach Road Sea Point", "Cape Town", "8001", "wwatson", "wwATsoNl", null);
        Assert.assertEquals("Lina", customer.getFirstName());
    }

    @Test
    public void testUpdateAdmin() throws Exception
    {
        Customer customer = CustomerFactory.createCustomer("Lina", "Doe", "0821298252", "307 Beach Road Sea Point", "Cape Town", "7734", "wwatson", "wwATsoNl", null);

        Customer newCustomer = new Customer.Builder(customer.getLastName())
                .copy(customer)
                .phoneNumber("0841298555")
                .build();

        Assert.assertEquals("0821298252", customer.getPhoneNumber());
        Assert.assertEquals("0841298555", newCustomer.getPhoneNumber());
    }

}