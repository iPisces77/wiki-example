package com.example.wiki.domain;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 电子书快照表 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EbookSnapshot implements Serializable {

  private static final long serialVersionUID = 1L;
  /** id */
  private Long id;
  /** 电子书id */
  private Long ebookId;
  /** 快照日期 */
  private LocalDate date;
  /** 阅读数 */
  private Integer viewCount;
  /** 点赞数 */
  private Integer voteCount;
  /** 阅读增长 */
  private Integer viewIncrease;
  /** 点赞增长 */
  private Integer voteIncrease;
}
