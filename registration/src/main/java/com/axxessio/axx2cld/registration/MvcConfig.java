package com.axxessio.axx2cld.registration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/registration").setViewName("registration");
    }
/*
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/registration")
			.allowedOrigins("http://localhost:8000")
			.allowedMethods("GET")
			.allowCredentials(false).maxAge(3600);
	}
*/
}