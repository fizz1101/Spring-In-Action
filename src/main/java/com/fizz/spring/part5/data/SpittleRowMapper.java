package com.fizz.spring.part5.data;

import com.fizz.spring.part5.entity.Spittle;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SpittleRowMapper implements RowMapper<Spittle> {

    public Spittle mapRow(ResultSet resultSet, int i) throws SQLException {
        Spittle spittle = new Spittle();
        spittle.setId(resultSet.getInt("id"));
        spittle.setMessage(resultSet.getString("message"));
        spittle.setLongitude(resultSet.getDouble("longitude"));
        spittle.setLatitude(resultSet.getDouble("latitude"));
        spittle.setTime(resultSet.getDate("created_at"));
        return spittle;
    }

}
