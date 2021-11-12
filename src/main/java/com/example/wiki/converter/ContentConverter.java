package com.example.wiki.converter;

import com.example.wiki.domain.Content;
import com.example.wiki.request.DocSaveRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author 付海鑫
 * @date 2021年11月11日 16:39
 */
@Mapper(componentModel = "spring")
public interface ContentConverter {

  @Mapping(source = "content", target = "content")
  Content vo2Do(DocSaveRequest request);
}
