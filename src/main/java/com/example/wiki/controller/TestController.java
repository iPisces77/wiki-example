package com.example.wiki.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 付海鑫
 * @date 2021年11月08日 22:11
 */
@RestController
public class TestController {
  @Value("${test.hello:你好}")
  private String hello;

  @GetMapping("/hello")
  public String hello() {

    return "Hello World";
  }

  @PostMapping("/hello/post")
  public String helloPost(String name) {
    return "Hello World,Post " + name;
  }
}
