package com.tuxdev.kontaweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by j.sanchez.chaves on 3/14/2018.
 * KONTA-pom
 */
@SpringBootApplication (exclude={DataSourceAutoConfiguration.class})
@EnableSwagger2
//@EnableOAuth2Sso
//
@EnableJpaRepositories(basePackages = {"com.tuxdev.kontaweb.dao.db.interfaces"})
@ComponentScan(basePackages = "com.tuxdev.kontaweb")
@EntityScan(basePackages = {"com.tuxdev.kontaweb.domain.persistence"})
public class Swagger2SpringBoot extends SpringBootServletInitializer {

    /**
     * Application start initialize the application by executing SpringApplication.run.
     *
     * @param args {@link String} basic arguments array.
     */
    public static void main(String[] args) {
        SpringApplication.run(Swagger2SpringBoot.class, args);
    }


    /**
     * Configure the application. Normally all you would need to do it add sources (e.g.
     * config classes) because other settings have sensible defaults. You might choose
     * (for instance) to add default command line arguments, or set an active Spring
     * profile.
     *
     * @param application {@link SpringApplicationBuilder} builder for the application context.
     * @return {@link SpringApplicationBuilder} the application builder
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Swagger2SpringBoot.class);
    }
}
