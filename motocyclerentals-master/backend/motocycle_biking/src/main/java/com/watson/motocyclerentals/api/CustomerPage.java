package com.watson.motocyclerentals.api;

import com.watson.motocyclerentals.domain.Customer;
import com.watson.motocyclerentals.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.HttpHeaders;



import java.util.List;

/**
 * Created by Long on 4/24/2018.
 */
@RestController
@RequestMapping("/api/**")
public class CustomerPage {

    @Autowired
    private CustomerService service;
    //http://localhost:8090/api/customers
    //-------------------Retrieve All Customers--------------------------------------------------------
    //http://localhost:8090/api/customers
    @RequestMapping(value = "/customers/", method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> listAllCustomers() {
        List<Customer> customers = service.findAll();
        if(customers.isEmpty()){
            return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
    }


    //-------------------Retrieve Single Customer--------------------------------------------------------

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") long id) {
        System.out.println("Fetching Customer with id " + id);
        Customer customer = service.findById(id);
        if (customer == null) {
            System.out.println("Customer with id " + id + " not found");
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }


    //-------------------Create a Customer--------------------------------------------------------

    @RequestMapping(value = "/customer/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createCustomer(@RequestBody Customer customer, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Subject " + customer.getFirstName());

//     USE THIS IF YOU WANT TO CHECK UNIQUE OBJECT
//      if (SubjectService.isSubjectExist(Subject)) {
//            System.out.println("A Subject with name " + Subject.getName() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }

        service.save(customer);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/customer/{id}").buildAndExpand(customer.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }


    //------------------- Update a Customer --------------------------------------------------------

    @RequestMapping(value = "/customer/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @RequestBody Customer Customer) {
        System.out.println("Updating Customer " + id);

        Customer currentCustomer = service.findById(id);

        if (currentCustomer==null) {
            System.out.println("Customer with id " + id + " not found");
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }

        Customer updatedCustomer = new Customer
                .Builder(currentCustomer.getLastName())
                .copy(currentCustomer)
                .build();
        service.update(updatedCustomer);
        return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.OK);
    }


    //------------------- Delete a Customer --------------------------------------------------------

    @RequestMapping(value = "/customer/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Customer with id " + id);

        Customer customer = service.findById(id);
        if (customer == null) {
            System.out.println("Unable to delete. Customer with id " + id + " not found");
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }

        service.delete(customer);
        return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
    }
}




/*@RestController
@RequestMapping(value="/customer/**")
public class CustomerPage {

    @Autowired
    private CustomerService service;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public List<Rental> getRentals(@PathVariable Long id)
    {
        return service.getRental(id);
    }

    @RequestMapping(value="/customers", method=RequestMethod.GET)

    public List<CustomerResource> getCustomers()
    {
        List<CustomerResource> hateoas = new ArrayList();
        List<Customer> customers = service.getCustomer();

        for (Customer c: customers)
        {
            CustomerResource res = new CustomerResource
                    .Builder(c.getLastName())
                    .firstName(c.getFirstName())
                    .phoneNumber(c.getPhoneNumber())
                    .addressEmbeddable(c.getAddressEmbeddable())
                    .loginEmbeddable(c.getLoginEmbeddable())
                    .rentals(c.getRentals())
                    .build();

            Link branches = new Link("http://localhost:8080/customer" + res.getResid().toString())
                    .withRel("cust");
            res.add(branches);
            hateoas.add(res);
        }

        return hateoas;
    }
}*/

