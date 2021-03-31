package com.union.salesmanagementcore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@PropertySource(value = "classpath:META-INF/v1_sales-management-core.properties", encoding = "UTF-8")
public class SwaggerConfig {

    @Bean
    public Docket apis() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.union.salesmanagementcore"))
                .paths(PathSelectors.any())
                .build();
    }
}