package com.fizz.spring.part5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.type.filter.RegexPatternTypeFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.regex.Pattern;

/**
 * ContextLoaderListener配置
 */
@Configuration
@ComponentScan(
        basePackages = {"com.fizz.spring"},     //启用组件扫描
        excludeFilters = {
                @Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
        })
@ImportResource({
        "classpath:config/part8/root-config.xml",
        "classpath:config/part9/root-config.xml"
})
public class RootConfig {

    public static class Webpackage extends RegexPatternTypeFilter {
        public Webpackage() {
            super(Pattern.compile("com\\.web"));
        }
    }

}
