package com.example.wiki.controller;

import com.example.wiki.request.DocQueryRequest;
import com.example.wiki.request.DocSaveRequest;
import com.example.wiki.response.CommonResponse;
import com.example.wiki.response.DocQueryResponse;
import com.example.wiki.response.PageResponse;
import com.example.wiki.service.DocService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 付海鑫
 * @date 2021年11月09日 15:54
 */
@RestController
@RequestMapping("/doc")
public class DocController {

  private final DocService docService;

  public DocController(DocService docService) {
    this.docService = docService;
  }

  @GetMapping("/all")
  public CommonResponse all() {
    CommonResponse<List<DocQueryResponse>> resp = new CommonResponse<>();
    List<DocQueryResponse> list = docService.all();
    resp.setContent(list);
    return resp;
  }

  @GetMapping("/list")
  public CommonResponse<PageResponse<DocQueryResponse>> list(@Validated DocQueryRequest request) {
    var list = docService.list(request);
    var DocCommonResponse = new CommonResponse<PageResponse<DocQueryResponse>>();
    DocCommonResponse.setContent(list);
    return DocCommonResponse;
  }
  /** 保存 */
  @PostMapping("/save")
  public CommonResponse save(@RequestBody @Validated DocSaveRequest request) {
    docService.save(request);
    return new CommonResponse<>();
  }

  @DeleteMapping("/delete/{idsStr}")
  public CommonResponse delete(@PathVariable(value = "idsStr") String ids) {
    var commonResponse = new CommonResponse<>();
    if (Objects.nonNull(ids)) {
      var split = ids.split(",");
      var strings = new ArrayList<String>(split.length);
      Collections.addAll(strings, split);
      docService.deleteByPrimaryKey(strings);
      return commonResponse;
    }
    commonResponse.setSuccess(false);
    return commonResponse;
  }

  @GetMapping("/content/{id}")
  public CommonResponse findContent(@PathVariable(value = "id") Long id) {
    var content = docService.findContent(id);
    var commonResponse = new CommonResponse<String>();
    commonResponse.setContent(content);
    return commonResponse;
  }
}
