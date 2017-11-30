package com.fizz.spring.part2.config;

import com.fizz.spring.part2.CDPlayer;
import com.fizz.spring.part2.CompactDisc;
import com.fizz.spring.part2.MediaPlayer;
import com.fizz.spring.part2.SgtPeppers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = {"com.fizz.spring.part2"})    //默认值：{},扫描当前类包路径
public class CDPlayerConfig {

    @Bean()
    public CompactDisc sgtPeppers() {
        return new SgtPeppers();
    }

    @Bean
    public MediaPlayer mediaPlayer() {
        return new CDPlayer(sgtPeppers());
    }

    /*@Bean(name = "player1")
    public CDPlayer cdPlayer() {
        return new CDPlayer(sgtPeppers());
    }*/

    /*@Bean(name = "player2")
    public CDPlayer cdPlayer2(CompactDisc cd) {
        return new CDPlayer(cd);
    }*/

}
