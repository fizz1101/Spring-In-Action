package com.fizz.spring.part2.config;

import com.fizz.spring.part2.CDPlayer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@Import({CDPlayerConfig.class, CDConfig.class})
@ImportResource("config/part2/cd.xml")
public class SoundSystemConfig {
}
