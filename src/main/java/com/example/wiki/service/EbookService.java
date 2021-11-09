package com.example.wiki.service;

import com.example.wiki.domain.Ebook;
import com.example.wiki.mapper.EbookMapper;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class EbookService {

  @Resource private EbookMapper ebookMapper;

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
}
