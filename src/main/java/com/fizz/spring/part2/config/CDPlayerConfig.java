package com.fizz.spring.part2.config;

import com.fizz.spring.part2.CDPlayer;
import com.fizz.spring.part2.CompactDisc;
import com.fizz.spring.part2.MediaPlayer;
import com.fizz.spring.part2.SgtPeppers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//@ComponentScan(basePackages = {"com.fizz.spring.part2"})    //默认值：{},扫描当前类包路径
public class CDPlayerConfig {

    /*@Bean
    public CompactDisc compactDisc() {
        return new SgtPeppers();
    }*/

    /*@Bean
    public MediaPlayer mediaPlayer(CompactDisc cd) {
        return new CDPlayer(cd);
    }*/

    @Bean()
    public CDPlayer cdPlayer() {
        return new CDPlayer(new SgtPeppers());
    }

    /*@Bean(name = "player")
    public CDPlayer cdPlayer2(CompactDisc cd) {
        return new CDPlayer(cd);
    }*/

}
