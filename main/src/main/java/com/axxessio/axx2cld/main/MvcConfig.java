package com.axxessio.axx2cld.main;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * This class extend WebMvcConfigurerAdapter and set the URL for a View.
 * @author wronka
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        registry.addViewController("/main").setViewName("main");
    }

}
