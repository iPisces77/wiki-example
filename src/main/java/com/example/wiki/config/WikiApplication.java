package com.example.wiki.config;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.example.wiki.mapper")
@ComponentScan("com.example.wiki")
@SpringBootApplication
public class WikiApplication {
  private static final Logger LOG = LoggerFactory.getLogger(WikiApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(WikiApplication.class, args);
    LOG.info("启动成功！！");
  }
}
