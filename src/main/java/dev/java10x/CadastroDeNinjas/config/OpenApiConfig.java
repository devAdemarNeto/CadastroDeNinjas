package dev.java10x.CadastroDeNinjas.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Cadastro de ninjas API")
                        .description("""
                                Api REST para gerendiamento de Ninjas e Missões.
                                Projeto desenvolvido com Spring Boot seguindo boas praticas de mercado para APIs REST.
                                """)
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Ademar Neto")
                                .email("ademarnetodev@outlook.com")
                                .url("https://github.com/devAdemarNeto"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0.html"))
                );
    }
}
