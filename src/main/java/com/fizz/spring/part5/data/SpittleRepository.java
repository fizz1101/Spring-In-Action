package com.fizz.spring.part5.data;

import com.fizz.spring.part5.entity.Spittle;

import java.util.List;

public interface SpittleRepository {

    List<Spittle> findSpittles(long max, int count);

    Spittle findOne(long spittleId);

}
