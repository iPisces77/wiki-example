package com.example.wiki.controller;

import com.example.wiki.response.CommonResponse;
import com.example.wiki.response.StatisticResponse;
import com.example.wiki.service.EBookSnapshotService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 付海鑫
 * @date 2021年11月16日 11:26
 */
@RestController
@RequestMapping("/ebook-snapshot")
public class EBookSnapshotController {
  private final EBookSnapshotService eBookSnapshotService;

  public EBookSnapshotController(EBookSnapshotService eBookSnapshotService) {
    this.eBookSnapshotService = eBookSnapshotService;
  }

  @GetMapping("/get-statistic")
  public CommonResponse getStatistic() {
    List<StatisticResponse> statisticResp = eBookSnapshotService.getStatistic();
    CommonResponse<List<StatisticResponse>> commonResp = new CommonResponse<>();
    commonResp.setContent(statisticResp);
    return commonResp;
  }

  @GetMapping("/get-30days-statistic")
  public CommonResponse get30DaysStatistic() {
    List<StatisticResponse> statisticResp = eBookSnapshotService.get30DaysStatistic();
    CommonResponse<List<StatisticResponse>> commonResp = new CommonResponse<>();
    commonResp.setContent(statisticResp);
    return commonResp;
  }
}
