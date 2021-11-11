package com.example.wiki.converter;

import com.example.wiki.domain.Doc;
import com.example.wiki.request.DocSaveRequest;
import com.example.wiki.response.DocQueryResponse;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author 付海鑫
 * @date 2021年11月11日 16:39
 */
@Mapper(componentModel = "spring")
public interface DocConverter {
  @Mapping(source = "id", target = "id", resultType = String.class)
  DocQueryResponse do2vo(Doc var1);

  Doc vo2Do(DocQueryResponse var1);

  Doc vo2Do(DocSaveRequest request);

  List<DocQueryResponse> do2voList(List<Doc> docList);
}
