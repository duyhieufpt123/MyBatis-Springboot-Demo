package com.example.demoMyBatis.config;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;
@Configuration
@OpenAPIDefinition(info = @Info(title = "Demo MyBatis API", version = "v1", description = "API documentation for Demo MyBatis Application"))
public class SwaggerConfig {
}


