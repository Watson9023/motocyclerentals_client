package com.watson.motocyclerentals.repository;
import com.watson.motocyclerentals.App;
import com.watson.motocyclerentals.domain.Customer;
import com.watson.motocyclerentals.domain.PaymentMethod;
import com.watson.motocyclerentals.domain.Rental;
import com.watson.motocyclerentals.factories.CustomerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.ArrayList;
import java.util.*;



/**
 * Created by Long on 4/24/2018.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class CustomerRepositoryTest extends AbstractTestNGSpringContextTests{
    private Long id;

    @Autowired
    private CustomerRepository repository;

    @BeforeMethod
    public void setUp() throws Exception {

    }

    @AfterMethod
    public void tearDown() throws Exception {

    }

    @Test
    public void create() throws Exception {
        List<PaymentMethod> paymentMethods = new ArrayList();
        List<Rental> rentals = new ArrayList();

        PaymentMethod paymentMethod = new PaymentMethod.Builder("Credit").Price(4000.00).build();
        paymentMethods.add(paymentMethod);

        Rental rental = new Rental.Builder("22-05-2018").returnDate("28-05-2018").paymentMethod(paymentMethods).build();
        rentals.add(rental);


        Customer customer = CustomerFactory.createCustomer("Watson", "Matunhire", "0821234252", "307 Beach Road Sea Point", "Cape Town", "8001", "wwatson", "wwATsoNl", rentals);

        repository.save(customer);

        id = customer.getId();

        Assert.assertNotNull(customer.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {

        Customer customer = repository.findOne(id);
        Assert.assertNotNull(customer);
        Assert.assertEquals("Watson", customer.getFirstName());
        Assert.assertEquals("Matunhire", customer.getLastName());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {

        Customer customer = (Customer)this.repository.findOne(this.id);
        Customer newCustomer =  new Customer.Builder(customer.getLastName()).copy(customer).firstName("Kelly").build();
        this.repository.save(newCustomer);
        Customer updatedCustomer = (Customer)this.repository.findOne(this.id);
        Assert.assertEquals("Kelly", updatedCustomer.getFirstName());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Customer customer = repository.findOne(id);

        repository.delete(customer);
        Customer deletedCustomer = repository.findOne(id);
        Assert.assertNull(deletedCustomer);

    }

}