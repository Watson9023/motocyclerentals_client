package com.watson.motocyclerentals;
import com.watson.motocyclerentals.domain.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Hello world!
 *
 */
/* @Configuration
@ComponentScan
@EnableWebMvc
@EnableAutoConfiguration
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SpringApplication.run(App.class, args);
    }
}
*/

public class App
{
        public static void main(String args[]) {
        RestTemplate restTemplate = new RestTemplate();
        Customer cust = restTemplate.getForObject("http://localhost:8090/api/customer/46", Customer.class);
        System.out.println(cust.toString());
    }

}
