package com.vpinfotechsoftware.customer.services;

import com.vpinfotechsoftware.customer.model.Customer;

import java.util.UUID;

public interface CustomerService {
    Customer getCustomerById(UUID customerId);
    Customer addCustomer(Customer customer);
    void updateCustomerDetails(UUID customerId, Customer customer);
    void removeCustomer(UUID customerId);
}
