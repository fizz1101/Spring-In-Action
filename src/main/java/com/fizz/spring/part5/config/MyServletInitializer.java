package com.fizz.spring.part5.config;

import com.fizz.spring.part5.filter.MyFilter;
import com.fizz.spring.part5.servlet.MyServlet;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@Deprecated
public class MyServletInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) throws ServletException {
        //注册Servlet
        ServletRegistration.Dynamic myServlet = servletContext.addServlet("myServlet", MyServlet.class);
        //映射Servlet
        myServlet.addMapping("/custom/**");

        //注册Filter
        FilterRegistration.Dynamic myFilter = servletContext.addFilter("myFilter", MyFilter.class);
        //映射Filter
        myFilter.addMappingForUrlPatterns(null, false, "/custom/*");
    }

}
