package com.alpaca.postit.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .useDefaultResponseMessages(true)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.alpaca.postit.post"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        // Swagger UI 에 출력될 API 내용
        return new ApiInfoBuilder()
                .title("Swagger Test")
                .description("SwaggerConfig")
                .version("3.0")
                .build();
    }
}