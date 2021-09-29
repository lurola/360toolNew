package com.appraisaltool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Evaluation360Application extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(Evaluation360Application.class, args);

    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Evaluation360Application.class);
    }
}
