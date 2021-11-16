package com.example.wiki.response;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatisticResponse {
  @DateTimeFormat(pattern = "YY-DD")
  private LocalDate date;

  private int viewCount;

  private int voteCount;

  private int viewIncrease;

  private int voteIncrease;
}
