package com.example.wiki.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 付海鑫
 * @date 2021年11月09日 20:27
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry
        .addMapping("/**")
        .allowedOrigins("/**")
        .allowedHeaders(CorsConfiguration.ALL)
        .allowedMethods(CorsConfiguration.ALL)
        .allowCredentials(true)
        .maxAge(3600);
  }
}
