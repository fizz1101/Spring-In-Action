package com.fizz.spring.part2.config;

import com.fizz.spring.part2.CDPlayer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@Import({CDPlayerConfig.class, CDConfig.class})
//@ImportResource("config/part2/cd.xml")    //影响到后续组件扫描内容，故屏蔽之
public class SoundSystemConfig {
}
