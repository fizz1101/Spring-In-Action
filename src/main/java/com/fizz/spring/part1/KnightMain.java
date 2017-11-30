package com.fizz.spring.part1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class KnightMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config/part1/knight.xml");
        AnnotationConfigApplicationContext context1 = new AnnotationConfigApplicationContext(com.fizz.spring.part1.config.KnightConfig.class);
        Knight knight = context.getBean("knight", Knight.class);
        knight.embarkOnQuest();
        context.close();
    }

}
