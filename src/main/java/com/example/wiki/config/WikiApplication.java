package com.example.wiki.config;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
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

  @Bean
  Snowflake snowflake() {
    return IdUtil.getSnowflake();
  }
}
