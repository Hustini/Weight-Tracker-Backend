package org.hustini.weighttracker;

import org.hustini.weighttracker.config.RateLimitFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WeightTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeightTrackerApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean<RateLimitFilter> rateLimitingFilter() {
        FilterRegistrationBean<RateLimitFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new RateLimitFilter());
        registration.addUrlPatterns("/api/*");
        return registration;
    }

}
