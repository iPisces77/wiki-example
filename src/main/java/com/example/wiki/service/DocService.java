package com.example.wiki.service;

import com.example.wiki.domain.Doc;
import com.example.wiki.mapper.DocMapper;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class DocService {

  @Resource private DocMapper docMapper;

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
}
