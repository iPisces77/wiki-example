package com.example.wiki.converter;

import com.example.wiki.domain.Ebook;
import com.example.wiki.request.EBookSaveRequest;
import com.example.wiki.response.EBookResponse;
import java.util.List;
import org.mapstruct.Mapper;

/**
 * @author 付海鑫
 * @date 2021年11月09日 16:58
 */
@Mapper(componentModel = "spring")
public interface EBookConverter {

  EBookResponse do2vo(Ebook var1);

  Ebook vo2Do(EBookResponse var1);

  Ebook vo2Do(EBookSaveRequest request);

  List<EBookResponse> do2voList(List<Ebook> eBookList);
}
