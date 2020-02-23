package com.hai.practice.jwt.common.config;

import com.hai.practice.jwt.filter.JwtFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;


//@Configuration
public class FilterConfig {

//    @Bean
//    public FilterRegistrationBean filterRegistrationBean(){
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(new JwtFilter());
//        filterRegistrationBean.setUrlPatterns(Arrays.asList("/api/*"));
//        return filterRegistrationBean;
//    }

}
