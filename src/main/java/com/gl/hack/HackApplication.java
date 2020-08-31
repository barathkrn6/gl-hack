package com.gl.hack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@RestController
@EnableSwagger2
@EnableAutoConfiguration
@ComponentScan
public class HackApplication {

    public static void main(String[] args) {
        SpringApplication.run(HackApplication.class, args);
    }

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("hack-api-services").enable(true)
                .apiInfo(apiInfo()).select().paths(PathSelectors.any()).build();
    }

    @SuppressWarnings("deprecation")
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("hack-api-services").description("hack-api-services").contact("Barath K")
                .license("Apache License Version 2.0").version("1.0.0").build();
    }

    @GetMapping("/health-check")
    public String healthCheck() {
        return "App is up and running";
    }
}
