package com.fizz.spring.part5.data;

import com.fizz.spring.part5.entity.Spitter;
import com.fizz.spring.part5.entity.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcSpittleRepository implements SpittleRepository {

    @Autowired
    private JdbcOperations jdbc;

    /*@Autowired
    public JdbcSpittleRepository(JdbcOperations jdbcOperations) {
        this.jdbc = jdbcOperations;
    }*/

    public List<Spittle> findSpittles(long max, int count) {
        String sql = "select id, message, created_at, latitude, longitude" +
                    " from Spittle" +
                    " where id < ?" +
                    " order by created_at desc limit ?";
        return jdbc.query(sql, new SpittleRowMapper(), max, count);
    }

    public Spittle findOne(long id) {
        String sql = "select id, message, created_at, latitude, longitude" +
                    " from Spittle" +
                    " where id = ?";
        Spittle spittle = new Spittle();
        try {
            spittle = jdbc.queryForObject(sql, Spittle.class, id);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
        }
        return spittle;
    }

}
