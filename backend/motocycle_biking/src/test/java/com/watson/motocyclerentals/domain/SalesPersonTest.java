package com.watson.motocyclerentals.domain;
import com.watson.motocyclerentals.factories.SalesPersonFactory;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;


/**
 * Created by Long on 4/24/2018.
 */
public class SalesPersonTest {
    @Before
    public void setUp() throws Exception
    {

    }

    @Test
    public void testCreateAdmin() throws Exception
    {
        SalesPerson salesPerson= SalesPersonFactory.createSalesPerson("Peter", "John", 8, 200.00, "pjohn", "pj100K", null);

        Assert.assertEquals("John", salesPerson.getLastName());
    }

    @Test
    public void testUpdateAdmin() throws Exception
    {
        SalesPerson salesPerson= SalesPersonFactory.createSalesPerson("Peter", "John", 8, 200.00, "pjohn", "pj100K", null);

        SalesPerson newSalesPerson = new SalesPerson.Builder(salesPerson.getLastName())
                .copy(salesPerson)
                .firstName("Piet")
                .build();

        Assert.assertEquals("Peter", salesPerson.getFirstName());
        Assert.assertEquals("Piet", newSalesPerson.getFirstName());
    }

}