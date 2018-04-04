package com.fizz.spring.part8.config;

import org.springframework.web.servlet.view.InternalResourceView;

import java.io.File;
import java.util.Locale;

public class FlowResourceView extends InternalResourceView {

    /**
     * 校验视图是否存在
     * @param locale
     * @return
     * @throws Exception
     */
    @Override
    public boolean checkResource(Locale locale) throws Exception {
        File file = new File(this.getServletContext().getRealPath("/") + getUrl());
        return file.exists();
    }
}
