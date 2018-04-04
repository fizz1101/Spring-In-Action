package com.fizz.spring.part8.data;

import com.fizz.spring.part8.entity.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper<Customer> {

    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setId(rs.getInt("id"));
        customer.setPhoneNumber(rs.getString("phone_number"));
        customer.setName(rs.getString("name"));
        customer.setAddress(rs.getString("address"));
        customer.setCity(rs.getString("city"));
        customer.setZipCode(rs.getString("zip_code"));
        customer.setState(rs.getString("state"));
        return customer;
    }

}
