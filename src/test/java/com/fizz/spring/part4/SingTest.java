package com.fizz.spring.part4;

import com.fizz.spring.part1.Knight;
import com.fizz.spring.part4.config.ConcertConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConcertConfig.class)
//@ImportResource("classpath:config/part4/audience.xml")
public class SingTest {

    @Test
    public void sing() {
        //ApplicationContext context = new ClassPathXmlApplicationContext("config/part4/audience.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(ConcertConfig.class);
        Performance performance = (Performance) context.getBean("sing");
        try {
            performance.sing();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
