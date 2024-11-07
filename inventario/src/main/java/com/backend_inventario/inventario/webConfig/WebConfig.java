package com.backend_inventario.inventario.webConfig;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(@NonNull CorsRegistry registry) {
        
        registry.addMapping("/**") 
                
        .allowedOrigins("*") 
               
        .allowedMethods("GET", "POST", "PUT", "DELETE")  
                      
        .maxAge(3600) 
                
        .allowCredentials(false); 
    }

}
