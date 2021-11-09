package com.example.wiki.config;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@MapperScan("com.example.wiki.mapper")
@ComponentScan("com.example.wiki")
@SpringBootApplication
public class WikiApplication {
  public static void main(String[] args) {
    SpringApplication.run(WikiApplication.class, args);
    log.info("启动成功！！");
  }
}