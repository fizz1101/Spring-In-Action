package com.fizz.spring.part8.service;

import com.fizz.spring.part8.data.CustomerRepository;
import com.fizz.spring.part8.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public  int saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer getCustomer(String phone) {
        return customerRepository.getCustomer(phone);
    }

}
