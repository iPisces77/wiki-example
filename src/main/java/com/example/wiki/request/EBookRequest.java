package com.example.wiki.request;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 电子书 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EBookRequest implements Serializable {
  private static final long serialVersionUID = 1L;
  /** id */
  private Long id;
  /** 名称 */
  private String name;
}
