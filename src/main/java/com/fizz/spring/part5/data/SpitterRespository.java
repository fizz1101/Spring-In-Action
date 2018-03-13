package com.fizz.spring.part5.data;

import com.fizz.spring.part5.entity.Spitter;

public interface SpitterRespository {

    Spitter save(Spitter spitter);

    Spitter findByUsername(String username);

}
