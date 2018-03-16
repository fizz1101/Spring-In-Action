package com.fizz.spring.part5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import java.io.IOException;

@Configuration
public class MultipartConfig {

    @Bean
    public MultipartResolver multipartResolver() throws IOException {
        return new StandardServletMultipartResolver();
        //Servlet3.0之前使用
        /*CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setUploadTempDir(new FileSystemResource("/temp/uploads"));
        multipartResolver.setMaxUploadSize(2097152);
        multipartResolver.setMaxInMemorySize(0);
        return multipartResolver;*/
    }

}
