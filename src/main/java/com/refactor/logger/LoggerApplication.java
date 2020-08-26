package com.refactor.logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
/**
 * To select which Loggers to exclude, uncomment the following and set the proper classes to exclude
 * @ComponentScan(basePackages = {"com.refactor.logger"}, excludeFilters={
        @ComponentScan.Filter(type= FilterType.ASSIGNABLE_TYPE, value= FileLogger.class)}) **/
public class LoggerApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(LoggerApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(LoggerApplication.class);
    }
}
