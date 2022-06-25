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
/*
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/greeting-javaconfig").allowedOrigins("http://localhost:8080");
			}
		};
	}        */


@Bean
public CorsFilter corsFilter() {
CorsConfiguration corsConfiguration = new CorsConfiguration();
corsConfiguration.setAllowCredentials(true);
corsConfiguration.setAllowedOrigins(Arrays.asList("https://portfolio-argentina-prog-f5593.web.app"));//http://localhost:4200
corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
"Accept", "Authorization", "Origin, Accept", "X-Request-With",
"Access-Control-Request-Method", "Access-Control-Request-Headers"));
corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-type", "Accept", "Authorization",
"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
corsConfiguration.setAllowedMethods(Arrays.asList("GET", "PUT", "POST", "DELETE", "OPTIONS"));
UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
return new CorsFilter(urlBasedCorsConfigurationSource);
}


}
