package com.fizz.spring.part8.data;

import com.fizz.spring.part8.entity.Customer;

public interface CustomerRepository {

    int save(Customer customer);

    Customer getCustomer(String phone);

}
