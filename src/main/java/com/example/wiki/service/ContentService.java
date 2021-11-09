package com.example.wiki.service;

import com.example.wiki.domain.Content;
import com.example.wiki.mapper.ContentMapper;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ContentService {

  @Resource private ContentMapper contentMapper;

  public int deleteByPrimaryKey(Long id) {
    return contentMapper.deleteByPrimaryKey(id);
  }

  public int insert(Content content) {
    return contentMapper.insert(content);
  }

  public int insertOrUpdate(Content content) {
    return contentMapper.insertOrUpdate(content);
  }

  public int insertOrUpdateSelective(Content content) {
    return contentMapper.insertOrUpdateSelective(content);
  }

  public int insertSelective(Content content) {
    return contentMapper.insertSelective(content);
  }

  public Content selectByPrimaryKey(Long id) {
    return contentMapper.selectByPrimaryKey(id);
  }

  public int updateByPrimaryKeySelective(Content content) {
    return contentMapper.updateByPrimaryKeySelective(content);
  }

  public int updateByPrimaryKey(Content content) {
    return contentMapper.updateByPrimaryKey(content);
  }

  public int updateBatch(List<Content> list) {
    return contentMapper.updateBatch(list);
  }

  public int updateBatchSelective(List<Content> list) {
    return contentMapper.updateBatchSelective(list);
  }

  public int batchInsert(List<Content> list) {
    return contentMapper.batchInsert(list);
  }
}
