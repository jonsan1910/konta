package com.tuxdev.kontaweb.boot.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Created by j.sanchez.chaves on 9/21/2017.
 */
@Configuration
public class SwaggerDocumentationConfig {
    /**
     * App information data. Sets the title description version of the App.
     *
     * @return {@link ApiInfoBuilder} object.
     */
    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Konta Swagger Services API ")
                .description("RESTfull APIS designed for the Konta Project")
                .license("")
                .licenseUrl("")
                .termsOfServiceUrl("")
                .version("1.0.0")
                .build();
    }

    /**
     * Creates bean of Docket object.
     *
     * @return {@link Docket} object.
     */
    @Bean
    public Docket customImplementation() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tuxdev.kontaweb"))
                .build()
                .apiInfo(apiInfo());
    }
}
