package org.h_brs.coolemicroservices;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
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