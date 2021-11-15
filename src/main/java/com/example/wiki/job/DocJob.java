package com.example.wiki.job;

import cn.hutool.core.lang.Snowflake;
import com.example.wiki.service.DocService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author 付海鑫
 * @date 2021年11月15日 20:27
 */
@Slf4j
@Component
public class DocJob {
  private final DocService docService;
  private final Snowflake snowFlake;

  public DocJob(DocService docService, Snowflake snowFlake) {
    this.docService = docService;
    this.snowFlake = snowFlake;
  }

  @Scheduled(cron = "5/30 * * * * ?")
  public void cron() {
    MDC.put("LOG_ID", String.valueOf(snowFlake.nextId()));
    log.info("更新电子书下的文档数据开始");
    long start = System.currentTimeMillis();
    docService.updateEbookInfo();
    log.info("更新电子书下的文档数据结束，耗时：{}毫秒", System.currentTimeMillis() - start);
  }
}
