package com.fizz.spring.part5.data;

import com.fizz.spring.part5.entity.Spitter;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SpitterRowMapper implements RowMapper<Spitter> {

    public Spitter mapRow(ResultSet resultSet, int i) throws SQLException {
        Spitter spitter = new Spitter();
        spitter.setId(resultSet.getLong("id"));
        spitter.setUsername(resultSet.getString("username"));
        spitter.setPassword(resultSet.getString("password"));
        spitter.setFirstName(resultSet.getString("first_name"));
        spitter.setLastName(resultSet.getString("last_name"));
        spitter.setEmail(resultSet.getString("email"));
        return spitter;
    }

}
