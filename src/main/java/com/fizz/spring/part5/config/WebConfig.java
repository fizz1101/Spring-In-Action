package com.fizz.spring.part5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
//import org.thymeleaf.templateresolver.TemplateResolver;

/**
 *DispatcherServlet配置
 */
@Configuration
@EnableWebMvc   //启用Spring MVC
@ComponentScan("com.fizz.spring.part5")    //启用组件扫描
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * 配置通用视图解析器
     * @return
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        resolver.setOrder(0);   //值越小优先级越高
        return resolver;
    }

    /**
     * thymeleaf模板视图解析器
     * @param templateEngine
     * @return
     */
    /*@Bean
    public ViewResolver thymeleafViewResolver(SpringTemplateEngine templateEngine) {
        ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
        thymeleafViewResolver.setTemplateEngine(templateEngine);
        return thymeleafViewResolver;
    }*/

    /**
     * 模板引擎
     * @param templateResolver
     * @return
     */
    /*@Bean
    public SpringTemplateEngine templateEngine(TemplateResolver templateResolver) {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }*/

    /**
     * 模板解析器
     * @return
     */
    /*@Bean
    public TemplateResolver templateResolver() {
        TemplateResolver templateResolver = new TemplateResolver();
        templateResolver.setPrefix("/WEB-INF/thymeleaf/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
        templateResolver.setOrder(1);
        return templateResolver;
    }*/

    /**
     * 配置静态资源处理
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
