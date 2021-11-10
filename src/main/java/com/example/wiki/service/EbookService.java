package com.example.wiki.service;

import com.example.wiki.converter.EBookConverter;
import com.example.wiki.domain.Ebook;
import com.example.wiki.mapper.EbookMapper;
import com.example.wiki.request.EBookQueryRequest;
import com.example.wiki.request.EBookSaveRequest;
import com.example.wiki.response.EBookResponse;
import com.example.wiki.response.PageResponse;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import java.util.List;
import java.util.Objects;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EbookService {
  private static final Logger LOG = LoggerFactory.getLogger(EbookService.class);
  private final EBookConverter converter;
  @Resource private EbookMapper ebookMapper;

  public EbookService(EBookConverter converter) {
    this.converter = converter;
  }

  public int deleteByPrimaryKey(Long id) {
    return ebookMapper.deleteByPrimaryKey(id);
  }

  public int insert(Ebook ebook) {
    return ebookMapper.insert(ebook);
  }

  public int insertOrUpdate(Ebook ebook) {
    return ebookMapper.insertOrUpdate(ebook);
  }

  public int insertOrUpdateSelective(Ebook ebook) {
    return ebookMapper.insertOrUpdateSelective(ebook);
  }

  public int insertSelective(Ebook ebook) {
    return ebookMapper.insertSelective(ebook);
  }

  public Ebook selectByPrimaryKey(Long id) {
    return ebookMapper.selectByPrimaryKey(id);
  }

  public int updateByPrimaryKeySelective(Ebook ebook) {
    return ebookMapper.updateByPrimaryKeySelective(ebook);
  }

  public int updateByPrimaryKey(Ebook ebook) {
    return ebookMapper.updateByPrimaryKey(ebook);
  }

  public int updateBatch(List<Ebook> list) {
    return ebookMapper.updateBatch(list);
  }

  public int updateBatchSelective(List<Ebook> list) {
    return ebookMapper.updateBatchSelective(list);
  }

  public int batchInsert(List<Ebook> list) {
    return ebookMapper.batchInsert(list);
  }

  public PageResponse<EBookResponse> list(EBookQueryRequest request) {
    PageMethod.startPage(request.getPage(), request.getSize());
    var list = ebookMapper.list(request);
    var ebookPageInfo = new PageInfo<Ebook>(list);
    var total = ebookPageInfo.getTotal();
    LOG.info("总行数:{}", total);
    var pages = ebookPageInfo.getPages();
    LOG.info("总页数:{}", pages);
    var eBookResponses = converter.do2voList(list);
    var eBookResponsePageResponse = new PageResponse<EBookResponse>();
    eBookResponsePageResponse.setList(eBookResponses);
    eBookResponsePageResponse.setTotal(total);
    return eBookResponsePageResponse;
  }

  public void save(EBookSaveRequest request) {
    var ebook = converter.vo2Do(request);
    if (Objects.nonNull(ebook.getId())) {
      ebookMapper.updateByPrimaryKey(ebook);
    } else {
      ebookMapper.insert(ebook);
    }
  }
}
