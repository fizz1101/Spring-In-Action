package com.fizz.spring.part5.config;

import com.fizz.spring.part8.config.FlowResourceView;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
//import org.thymeleaf.templateresolver.TemplateResolver;

/**
 *DispatcherServlet配置
 */
@Configuration
@EnableWebMvc   //启用Spring MVC
@ComponentScan({"com.fizz.spring.part5"})    //启用组件扫描
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * 配置通用视图解析器
     * @return
     */
    @Bean
    public ViewResolver viewResolver() {
        //该解析器默认优先级是Integer.MAX，且不管视图是否存在均会返回，因此一般都作为最后一个视图解析器
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    /**
     * webflow流程视图解析器
     * @return
     */
    @Bean
    public ViewResolver flowViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(FlowResourceView.class);//调用用自定义校验视图
        resolver.setPrefix("/WEB-INF/flows/");
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
