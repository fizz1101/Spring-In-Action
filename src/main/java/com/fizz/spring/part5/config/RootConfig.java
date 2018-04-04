package com.fizz.spring.part5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * ContextLoaderListener配置
 */
@Configuration
@ComponentScan(
        //basePackages = {"com.fizz.spring.part5"},
        excludeFilters = {
                @Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
        })
@ImportResource("classpath:config/part8/root-config.xml")
public class RootConfig {

    /*public static class Webpackage extends RegexPatternTypeFilter {
        public Webpackage() {
            super(Pattern.compile("spitter\\.web"));
        }
    }*/

}
