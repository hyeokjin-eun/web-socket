package com.example.server.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "채팅 서비스 API 명세서",
                description = "채팅 서비스",
                version = "1.0")
)
@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi chatOpenApi() {
        String[] paths = {"/**"};
        return GroupedOpenApi.builder()
                .group("채팅서비스")
                .pathsToMatch(paths)
                .build();
    }
}
