package com.example.wiki.service;

import cn.hutool.core.lang.Snowflake;
import com.example.wiki.converter.DocConverter;
import com.example.wiki.domain.Doc;
import com.example.wiki.mapper.DocMapper;
import com.example.wiki.request.DocQueryRequest;
import com.example.wiki.request.DocSaveRequest;
import com.example.wiki.response.DocQueryResponse;
import com.example.wiki.response.PageResponse;
import com.github.pagehelper.PageInfo;
import java.util.List;
import java.util.Objects;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DocService {
  private static final Logger LOG = LoggerFactory.getLogger(DocService.class);
  private final DocConverter converter;
  private final Snowflake snowflake;
  @Resource private DocMapper docMapper;

  public DocService(DocConverter converter, Snowflake snowflake) {
    this.converter = converter;
    this.snowflake = snowflake;
  }

  public int deleteByPrimaryKey(Long id) {
    return docMapper.deleteByPrimaryKey(id);
  }

  public int insert(Doc doc) {
    return docMapper.insert(doc);
  }

  public int insertOrUpdate(Doc doc) {
    return docMapper.insertOrUpdate(doc);
  }

  public int insertOrUpdateSelective(Doc doc) {
    return docMapper.insertOrUpdateSelective(doc);
  }

  public int insertSelective(Doc doc) {
    return docMapper.insertSelective(doc);
  }

  public Doc selectByPrimaryKey(Long id) {
    return docMapper.selectByPrimaryKey(id);
  }

  public int updateByPrimaryKeySelective(Doc doc) {
    return docMapper.updateByPrimaryKeySelective(doc);
  }

  public int updateByPrimaryKey(Doc doc) {
    return docMapper.updateByPrimaryKey(doc);
  }

  public int updateBatch(List<Doc> list) {
    return docMapper.updateBatch(list);
  }

  public int updateBatchSelective(List<Doc> list) {
    return docMapper.updateBatchSelective(list);
  }

  public int batchInsert(List<Doc> list) {
    return docMapper.batchInsert(list);
  }

  public void save(DocSaveRequest request) {

    var ebook = converter.vo2Do(request);
    if (Objects.nonNull(ebook.getId())) {

      docMapper.updateByPrimaryKey(ebook);
    } else {
      var id = snowflake.nextId();
      ebook.setId(id);
      docMapper.insertSelective(ebook);
    }
  }

  public PageResponse<DocQueryResponse> list(DocQueryRequest request) {
    var list = docMapper.list(request);

    var docPageInfo = new PageInfo<Doc>(list);
    var total = docPageInfo.getTotal();
    LOG.info("总行数:{}", total);
    var pages = docPageInfo.getPages();
    LOG.info("总页数:{}", pages);
    var docResponses = converter.do2voList(list);
    var docResponsePageResponse = new PageResponse<DocQueryResponse>();
    docResponsePageResponse.setList(docResponses);
    docResponsePageResponse.setTotal(total);
    return docResponsePageResponse;
  }

  public List<DocQueryResponse> all() {

    return converter.do2voList((docMapper.all()));
  }
}
