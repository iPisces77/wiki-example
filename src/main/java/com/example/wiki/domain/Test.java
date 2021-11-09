package com.example.wiki.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 测试
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Test implements Serializable {

  /**
   * id
   */
  private Long id;

  /**
   * 名称
   */
  private String name;

  /**
   * 密码
   */
  private String password;

  private static final long serialVersionUID = 1L;
}