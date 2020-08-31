package com.vpinfotechsoftware.customer.controller;

import com.vpinfotechsoftware.customer.model.Customer;
import com.vpinfotechsoftware.customer.services.CustomerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/vpinfotech/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerDetails(@PathVariable("customerId")UUID customerId){
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer>addNewCustomer(@RequestBody Customer customer){
        HttpHeaders header= new HttpHeaders();
        Customer customerDetail= customerService.addCustomer(customer);
        //header.add("Location", "/api/vpinfotech/v1/customer/"+customer.getId().toString());
        return new ResponseEntity<Customer>(customerDetail, HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Customer> UpdateCustomerDetails(@PathVariable("customerId") UUID customerId, @RequestBody Customer customer){
        customerService.updateCustomerDetails(customerId, customer);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Customer> removeCustomerAccount(@PathVariable("customerId") UUID customerId){
        customerService.removeCustomer(customerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
