package com.example.wiki;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class WikiApplication {
  public static void main(String[] args) {
    SpringApplication.run(WikiApplication.class, args);
  }
}
