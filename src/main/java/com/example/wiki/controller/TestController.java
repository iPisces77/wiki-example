package com.example.wiki.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 付海鑫
 * @date 2021年11月08日 22:11
 */
@RestController
public class TestController {
  @GetMapping("/hello")
  public String hello() {

    return "Hello World";
  }
}
