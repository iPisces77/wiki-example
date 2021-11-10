package com.example.wiki.controller;

import com.example.wiki.request.EBookQueryRequest;
import com.example.wiki.request.EBookSaveRequest;
import com.example.wiki.response.CommonResponse;
import com.example.wiki.response.EBookResponse;
import com.example.wiki.response.PageResponse;
import com.example.wiki.service.EbookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 付海鑫
 * @date 2021年11月09日 15:54
 */
@RestController
@RequestMapping("/ebook")
public class EBookController {

  private final EbookService ebookService;

  public EBookController(EbookService ebookService) {
    this.ebookService = ebookService;
  }

  @GetMapping("/list")
  public CommonResponse<PageResponse<EBookResponse>> list(EBookQueryRequest request) {
    var list = ebookService.list(request);
    var ebookCommonResponse = new CommonResponse<PageResponse<EBookResponse>>();
    ebookCommonResponse.setContent(list);
    return ebookCommonResponse;
  }
  /** 保存 */
  @PostMapping("/save")
  public CommonResponse save(EBookSaveRequest request) {
    ebookService.save(request);
    return new CommonResponse<>();
  }
}
