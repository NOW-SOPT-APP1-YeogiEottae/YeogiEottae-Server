package com.joinseminar.yeogieottae.global.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI(){
        Info info = new Info()
                .title("여기어때 API Swagger")
                .description("NOW SOPT 34th 모바일 앱 1팀 여기어때 API 명세서")
                .version("v1");

        return new OpenAPI()
                .components(new Components())
                .info(info);
    }
}
