package com.fizz.spring.part5.service;

import com.fizz.spring.part5.data.SpitterRespository;
import com.fizz.spring.part5.entity.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpitterService {

    @Autowired
    private SpitterRespository spitterRespository;

    public Spitter save(Spitter spitter) {
        return spitterRespository.save(spitter);
    }

    public Spitter findByUsername(String username) {
        return spitterRespository.findByUsername(username);
    }

}
