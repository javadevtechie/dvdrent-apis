package com.dvd.cofig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableSwagger2
@ComponentScan(basePackageClasses = {
        MasterRecordsController.class
})
public class SwaggerConfig {

    @Bean
    public Docket containerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dvd"))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/");
    }

    @Bean
    public UiConfiguration uiConfiguration() {
        return UiConfigurationBuilder.builder()
                .build();
    }
}
