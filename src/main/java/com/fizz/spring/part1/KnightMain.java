package com.fizz.spring.part1;

import com.fizz.spring.part1.config.KnightConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class KnightMain {

    private static KnightConfig knightConfig;

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config/knight.xml");
        Knight knight = context.getBean("knight", Knight.class);
        //Knight knight = knightConfig.knight();
        knight.embarkOnQuest();
        context.close();
    }

}
