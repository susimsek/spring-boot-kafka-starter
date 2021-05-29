package io.susimsek.kafka.demo.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Configuration
public class OpenApiConfig {

    final Environment environment;
 
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(metaData());
    }

    @Bean
    public GroupedOpenApi customApi() {
        return GroupedOpenApi.builder()
                .group("api")
                .pathsToMatch("/api/**")
                .build();
    }

    private Info metaData() {
        return new Info()
                .title(environment.getProperty("openapi.title"))
                .description(environment.getProperty("openapi.description"))
                .version(environment.getProperty("openapi.version"))
                .termsOfService(environment.getProperty("openapi.terms-of-service-url"))
                .license(new License().
                        name(environment.getProperty("openapi.license"))
                        .url(environment.getProperty("openapi.license-url"))
                );
    }
}