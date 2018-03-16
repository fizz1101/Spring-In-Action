package com.fizz.spring.part5.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import com.fizz.spring.part5.filter.MyFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {WebConfig.class};
    }

    //将DispatcherServlet映射到"/"
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    //启用对multipart请求的支持
    @Override
    protected void customizeRegistration(Dynamic registration) {
        //设置文件临时路径；单文件大小2M；总文件大小6M；所有文件均写入磁盘
        MultipartConfigElement element = new MultipartConfigElement("c://spittr_storage/uploads/temp", 2097152, 6291456, 0);
        registration.setMultipartConfig(element);
    }

    //注册Filter
    /*@Override
    protected Filter[] getServletFilters() {
        return new Filter[] { new MyFilter() };
    }*/
}
