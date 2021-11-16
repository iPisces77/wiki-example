package com.example.wiki.config;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableScheduling
@MapperScan("com.example.wiki.mapper")
@ComponentScan("com.example.wiki")
@SpringBootApplication
public class WikiApplication {
  private static final Logger LOG = LoggerFactory.getLogger(WikiApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(WikiApplication.class, args);
    LOG.info("启动成功！！");
  }

  @Bean
  Snowflake snowFlake() {
    return IdUtil.getSnowflake();
  }
}
