package com.backend_inventario.inventario.webConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(@NonNull CorsRegistry registry) {
        
        registry.addMapping("/**") // Permitir CORS para todas as rotas
                
        .allowedOrigins("http://localhost:3000") // Adicione os domínios permitidos
               
        .allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos permitidos
               
        .allowedHeaders("*") // Permitir todos os cabeçalhos
                
        .allowCredentials(true); // Permitir credenciais
    }

}
