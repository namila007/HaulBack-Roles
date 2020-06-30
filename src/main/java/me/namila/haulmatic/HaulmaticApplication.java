package me.namila.haulmatic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static me.namila.haulmatic.constants.statics.ApiEndPoints.BASE_END_POINT;

@SpringBootApplication
@EnableSwagger2
@EnableMongoAuditing
public class HaulmaticApplication {

    public static void main(String[] args) {
        SpringApplication.run(HaulmaticApplication.class, args);
    }

    @Bean
    public Docket roleApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("me.namila.haulmatic.controllers"))
                .build();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping(BASE_END_POINT).allowedOrigins("*");
            }
        };
    }
}
