package com.example.wiki.domain;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 付海鑫
 * @date 2021年11月16日 11:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Statistic {
  private LocalDate date;

  private int viewCount;

  private int voteCount;

  private int viewIncrease;

  private int voteIncrease;
}
