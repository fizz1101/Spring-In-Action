package com.fizz.spring.part2.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.fizz.spring.part2"})    //默认值：{},扫描当前类包路径
public class CDPlayerConfig {
}
