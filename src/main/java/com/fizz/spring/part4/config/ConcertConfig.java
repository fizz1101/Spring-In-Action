package com.fizz.spring.part4.config;

import com.fizz.spring.part4.Audience;
import com.fizz.spring.part4.Sing;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.fizz.spring.part4"})
@EnableAspectJAutoProxy
public class ConcertConfig {

    @Bean(name = "sing")
    public Sing sing() {
        return new Sing();
    }

    @Bean(name = "audience")
    public Audience audience() {
        return new Audience();
    }

}
