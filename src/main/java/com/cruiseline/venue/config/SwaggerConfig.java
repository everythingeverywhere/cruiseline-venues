package com.cruiseline.venue.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static springfox.documentation.builders.PathSelectors.ant;

/**
 * Created by Aniruth Parthasarathy
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket swaggerSettings() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.venue.controller"))
                .paths(Predicates.and(ant("/**"),
                        Predicates.not(ant("/error/**")),
                        Predicates.not(ant("/admin/**"))))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SpringBoot Reference App - Venue micro-service")
                .description("This micro-service talks to H2 for test, Postgres for prod\n")
                .termsOfServiceUrl("")
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")
                .version("2.0")
                .contact(new Contact("Mike Wright", "", "mwright@pivotal.io"))
                .build();
    }

}