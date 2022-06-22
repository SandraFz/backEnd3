package com.portfolio.MyPortfolio8;

import java.util.Arrays;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class MyPortfolio8Application {

	public static void main(String[] args) {
		SpringApplication.run(MyPortfolio8Application.class, args);
	}
        
@Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOrigins(Arrays.asList("https://nombreDeTuProyecto.web.app"));
        config.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "content-type", "Accept",
                "Authorization", "Origin, Accept", "x-auth-token"));
        config.setExposedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "content-type", "Accept",
                "Authorization", "Origin, Accept", "x-auth-token"));
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

}
