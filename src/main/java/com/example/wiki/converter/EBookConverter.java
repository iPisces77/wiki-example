package com.example.wiki.converter;

import com.example.wiki.domain.Ebook;
import com.example.wiki.request.EBookSaveRequest;
import com.example.wiki.response.EBookQueryResponse;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author 付海鑫
 * @date 2021年11月09日 16:58
 */
@Mapper(componentModel = "spring")
public interface EBookConverter {
  @Mapping(source = "id", target = "id", resultType = String.class)
  EBookQueryResponse do2vo(Ebook var1);

  Ebook vo2Do(EBookQueryResponse var1);

  Ebook vo2Do(EBookSaveRequest request);

  List<EBookQueryResponse> do2voList(List<Ebook> eBookList);
}
