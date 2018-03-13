package com.fizz.spring.part5.data;

import com.fizz.spring.part5.entity.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcSpitterRespository implements SpitterRespository {

    @Autowired
    private JdbcOperations jdbc;

    public Spitter save(Spitter spitter) {
        String sql = "insert into Spitter (username, password, first_name, last_name, email)" +
                    " values (?, ?, ?, ?, ?)";
        jdbc.update(sql,
                spitter.getUsername(),
                spitter.getPassword(),
                spitter.getFirstName(),
                spitter.getLastName(),
                spitter.getEmail());
        return spitter; // TODO: Determine value for id
    }

    public Spitter findByUsername(String username) {
        String sql = "select * from Spitter where username = ?";
        Spitter spitter = new Spitter();
        try {
            spitter = jdbc.queryForObject(sql, new SpitterRowMapper(), username);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
        }
        return spitter;
    }

}
