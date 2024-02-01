package com.teste.movies.springdoc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {
    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Pior Filme do Golden Raspberry Awards.")
                        .version("v1")
                        .description("API RESTful para possibilitar a leitura da lista de indicados e vencedores \n" +
                                "da categoria Pior Filme do Golden Raspberry Awards.")
                );
    }
}
