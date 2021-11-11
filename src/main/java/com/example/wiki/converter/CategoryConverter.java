package com.example.wiki.converter;

import com.example.wiki.domain.Category;
import com.example.wiki.request.CategorySaveRequest;
import com.example.wiki.response.CategoryQueryResponse;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author 付海鑫
 * @date 2021年11月09日 16:58
 */
@Mapper(componentModel = "spring")
public interface CategoryConverter {
  @Mapping(source = "id", target = "id", resultType = String.class)
  CategoryQueryResponse do2vo(Category var1);

  Category vo2Do(CategoryQueryResponse var1);

  Category vo2Do(CategorySaveRequest request);

  List<CategoryQueryResponse> do2voList(List<Category> categoryList);
}
