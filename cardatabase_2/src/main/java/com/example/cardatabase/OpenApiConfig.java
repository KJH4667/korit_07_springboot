package com.example.cardatabase;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI carDatabaseOpenApi() {
        return new OpenAPI()
                .info(new Info()
                .title("Car REST API")
                .description("My car stock")
                .version("1.0")
        ); // 생성자는 return 을 명시하지 않는다. return 있으니 생성자라고 볼수 없다. 메서드다.
    }
}
