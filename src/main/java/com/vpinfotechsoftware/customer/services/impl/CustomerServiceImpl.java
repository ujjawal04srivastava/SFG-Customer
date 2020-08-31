package com.vpinfotechsoftware.customer.services.impl;

import com.vpinfotechsoftware.customer.model.Customer;
import com.vpinfotechsoftware.customer.services.CustomerService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public Customer getCustomerById(UUID customerId) {

        return Customer.builder().id(UUID.randomUUID())
                .custName("Ujjawal Srivastava")
                .contactNumber(741570126)
                .custEMailId("ujjawal04srivastava@gmail.com")
                .build();
    }

    @Override
    public Customer addCustomer(Customer customer) {
        log.info("Registration Process started........");
        Customer cust= Customer.builder()
                .id(UUID.randomUUID())
                .custName("Priyanka Kulshrestha")
                .contactNumber(123456789)
                .custEMailId("priyanka.kulshrestha@gmail.com")
                .build();
        log.info("Customer Added Successfully........"+cust);
        return cust;

    }

    @Override
    public void updateCustomerDetails(UUID customerId, Customer customer) {
        Customer.builder()
                .id(UUID.randomUUID())
                .custEMailId("st_sachin.tendulkar@gmail.com")
                .build();
        log.info("Customer Updated Successfully........"+ HttpStatus.NO_CONTENT);
    }

    @Override
    public void removeCustomer(UUID customerId) {
        log.info("Customer removed Successfully........");
    }
}
