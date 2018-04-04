package com.fizz.spring.part8.data;

import com.fizz.spring.part8.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcCustomerRepository implements CustomerRepository {

    @Autowired
    private JdbcOperations jdbc;

    public int save(Customer customer) {
        String sql = "insert into customer (phone_number, name, address, city, zip_code, state) " +
                " values (?, ?, ?, ?, ?, ?)";
        int res = jdbc.update(sql,
                customer.getPhoneNumber(),
                customer.getName(),
                customer.getAddress(),
                customer.getCity(),
                customer.getZipCode(),
                customer.getState());
        System.out.println(res);
        return 0;
    }

    public Customer getCustomer(String phone) {
        String sql = "select * from customer where phone_number = ?";
        Customer customer = null;
        try {
            customer = jdbc.queryForObject(sql, new CustomerRowMapper(), phone);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
        }
        return customer;
    }

}
