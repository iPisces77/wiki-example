package com.example.wiki.response;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 付海鑫
 * @date 2021年11月09日 16:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EBookResponse implements Serializable {
  private static final long serialVersionUID = 1L;
  /** id */
  private Long id;
  /** 名称 */
  private String name;
  /** 分类1 */
  private Long category1Id;
  /** 分类2 */
  private Long category2Id;
  /** 描述 */
  private String description;
  /** 封面 */
  private String cover;
  /** 文档数 */
  private Integer docCount;
  /** 阅读数 */
  private Integer viewCount;
  /** 点赞数 */
  private Integer voteCount;
}
