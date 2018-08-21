package com.watson.motocyclerentals.repository;

import com.watson.motocyclerentals.App;
import org.springframework.beans.factory.annotation.Autowired;
import com.watson.motocyclerentals.domain.PaymentMethod;
import com.watson.motocyclerentals.domain.Rental;
import com.watson.motocyclerentals.factories.RentalFactory;
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
public class RentalRepositoryTest extends AbstractTestNGSpringContextTests {
    private Long id;

    @Autowired
    private RentalRepository repository;

    @BeforeMethod
    public void setUp() throws Exception {

    }

    @AfterMethod
    public void tearDown() throws Exception {

    }

    @Test
    public void create() throws Exception {
        List<PaymentMethod> paymentMethods = new ArrayList();

        PaymentMethod paymentMethod = new PaymentMethod.Builder("Credit").Price(4000.00).build();
        paymentMethods.add(paymentMethod);

        Rental rental = RentalFactory.createRental("22-05-2018", "28-05-2018", paymentMethods);

        repository.save(rental);

        id = rental.getId();

        Assert.assertNotNull(rental.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {

        Rental rental = repository.findOne(id);
        Assert.assertNotNull(rental);
        Assert.assertEquals("22-05-2018", rental.getPickUpDate());
        Assert.assertEquals("28-05-2018", rental.getReturnDate());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {

        Rental rental = (Rental)this.repository.findOne(this.id);
        Rental newRental =  new Rental.Builder(rental.getPickUpDate()).copy(rental).returnDate("27-08-2018").build();
        this.repository.save(newRental);
        Rental updatedRental = (Rental)this.repository.findOne(this.id);
        Assert.assertEquals("27-08-2018", updatedRental.getReturnDate());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Rental rental = repository.findOne(id);

        repository.delete(rental);
        Rental deletedRental = repository.findOne(id);
        Assert.assertNull(deletedRental);

    }
}