package com.ud.zuulserver2;

import com.ud.zuulserver2.filters.SimpleFilter;
import com.ud.zuulserver2.filters.ZuulErrorFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulServer
public class ZuulServer2Application {

    public static void main(String[] args) {
        SpringApplication.run(ZuulServer2Application.class, args);
    }

    @Bean
    public ZuulErrorFilter zuulErrorFilter() {
        return new ZuulErrorFilter();
    }

    @Bean
    public SimpleFilter simpleFilter() {
        return new SimpleFilter();
    }
}
