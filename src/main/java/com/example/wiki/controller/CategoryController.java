package com.example.wiki.controller;

import com.example.wiki.request.CategoryQueryRequest;
import com.example.wiki.request.CategorySaveRequest;
import com.example.wiki.response.CategoryQueryResponse;
import com.example.wiki.response.CommonResponse;
import com.example.wiki.response.PageResponse;
import com.example.wiki.service.CategoryService;
import java.util.List;
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
@RequestMapping("/category")
public class CategoryController {

  private final CategoryService categoryService;

  public CategoryController(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @GetMapping("/all")
  public CommonResponse all() {
    CommonResponse<List<CategoryQueryResponse>> resp = new CommonResponse<>();
    List<CategoryQueryResponse> list = categoryService.all();
    resp.setContent(list);
    return resp;
  }

  @GetMapping("/list")
  public CommonResponse<PageResponse<CategoryQueryResponse>> list(
      @Validated CategoryQueryRequest request) {
    var list = categoryService.list(request);
    var CategoryCommonResponse = new CommonResponse<PageResponse<CategoryQueryResponse>>();
    CategoryCommonResponse.setContent(list);
    return CategoryCommonResponse;
  }
  /** 保存 */
  @PostMapping("/save")
  public CommonResponse save(@RequestBody @Validated CategorySaveRequest request) {
    categoryService.save(request);
    return new CommonResponse<>();
  }

  @DeleteMapping("/delete/{id}")
  public CommonResponse delete(@PathVariable(value = "id") Long id) {
    var commonResponse = new CommonResponse<>();
    categoryService.deleteByPrimaryKey(id);
    return commonResponse;
  }
}
