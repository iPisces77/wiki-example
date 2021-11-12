package com.example.wiki.controller;

import com.example.wiki.request.UserQueryRequest;
import com.example.wiki.request.UserSaveRequest;
import com.example.wiki.response.CommonResponse;
import com.example.wiki.response.PageResponse;
import com.example.wiki.response.UserQueryResponse;
import com.example.wiki.service.UserService;
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
@RequestMapping("/user")
public class UserController {

  private final UserService ebookService;

  public UserController(UserService ebookService) {
    this.ebookService = ebookService;
  }

  @GetMapping("/list")
  public CommonResponse<PageResponse<UserQueryResponse>> list(@Validated UserQueryRequest request) {
    var list = ebookService.list(request);
    var ebookCommonResponse = new CommonResponse<PageResponse<UserQueryResponse>>();
    ebookCommonResponse.setContent(list);
    return ebookCommonResponse;
  }
  /** 保存 */
  @PostMapping("/save")
  public CommonResponse save(@RequestBody @Validated UserSaveRequest request) {
    ebookService.save(request);
    return new CommonResponse<>();
  }

  @DeleteMapping("/delete/{id}")
  public CommonResponse delete(@PathVariable(value = "id") Long id) {
    var commonResponse = new CommonResponse<>();
    ebookService.deleteByPrimaryKey(id);
    return commonResponse;
  }
}
