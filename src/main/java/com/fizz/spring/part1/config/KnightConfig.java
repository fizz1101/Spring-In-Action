package com.fizz.spring.part1.config;


import com.fizz.spring.part1.BraveKnight;
import com.fizz.spring.part1.Knight;
import com.fizz.spring.part1.Quest;
import com.fizz.spring.part1.SlayDragonQuest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KnightConfig {

    @Bean
    public Knight knight() {
        return new BraveKnight(quest());
    }

    @Bean
    public Quest quest() {
        return new SlayDragonQuest(System.out);
    }

}
