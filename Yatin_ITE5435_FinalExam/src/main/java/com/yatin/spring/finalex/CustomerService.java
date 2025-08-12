package com.yatin.spring.finalex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    
    public Optional<Customer> findCustomerById(String id) {
        return customerRepository.findById(id);
    }
}