package com.example.crud.session;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

///@Configuration
public class AppConfig {

	@Bean
	public FilterRegistrationBean<AuthFilter> filterRegistrationBean() {
		FilterRegistrationBean<AuthFilter> registrationBean = new FilterRegistrationBean<>();
		AuthFilter customURLFilter = new AuthFilter();

		registrationBean.setFilter(customURLFilter);
		registrationBean.addUrlPatterns("/*");
		registrationBean.setOrder(1); // set precedence
		return registrationBean;
	}
}