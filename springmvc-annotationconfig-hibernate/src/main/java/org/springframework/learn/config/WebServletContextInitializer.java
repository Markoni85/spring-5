package org.springframework.learn.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebServletContextInitializer
    extends AbstractAnnotationConfigDispatcherServletInitializer
{

    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { RootConfig.class };
    }
    
    protected Class<?>[] getServletConfigClasses()  {
        return new Class[] {WebMvcConfig.class};
    }
    
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

}