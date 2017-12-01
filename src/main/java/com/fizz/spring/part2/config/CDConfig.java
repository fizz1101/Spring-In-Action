package com.fizz.spring.part2.config;

import com.fizz.spring.part2.BlackDisc;
import com.fizz.spring.part2.CompactDisc;
import com.fizz.spring.part2.SgtPeppers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan(basePackages = {"com.fizz.spring.part2"})    //默认值：{},扫描当前类包路径
public class CDConfig {

    /*@Bean
    public SgtPeppers sgtPeppers() {
        return new SgtPeppers();
    }*/

    /*@Bean
    public BlackDisc blackDisc() {
        List<String> list = new ArrayList<String>();
        return new BlackDisc("BlackDisc", "Black", list);
    }*/

}
