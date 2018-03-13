package com.fizz.spring.part5.service;

import com.fizz.spring.part5.data.SpittleRepository;
import com.fizz.spring.part5.entity.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.provider.ConfigFile;

import java.util.List;

@Service
public class SpittleService {

    @Autowired
    private SpittleRepository spittleRepository;

    public List<Spittle> findSpittles(long max, int count) {
        return spittleRepository.findSpittles(max, count);
    }

    public Spittle findOne(long spittleId) {
        return spittleRepository.findOne(spittleId);
    }

}
