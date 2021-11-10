package com.example.wiki.config;

import com.example.wiki.interceptor.ActionInterceptor;
import com.example.wiki.interceptor.LoginInterceptor;
import javax.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {

  @Resource LoginInterceptor loginInterceptor;

  @Resource ActionInterceptor actionInterceptor;

  public void addInterceptors(InterceptorRegistry registry) {
    registry
        .addInterceptor(loginInterceptor)
        .addPathPatterns("/**")
        .excludePathPatterns(
            "/test/**",
            "/redis/**",
            "/user/login",
            "/category/all",
            "/ebook/list",
            "/doc/all/**",
            "/doc/vote/**",
            "/doc/find-content/**",
            "/ebook-snapshot/**");

    registry
        .addInterceptor(actionInterceptor)
        .addPathPatterns("/*/save", "/*/delete/**", "/*/reset-password");
  }
}
