package com.example.wiki.service;

import com.example.wiki.domain.Demo;
import com.example.wiki.mapper.DemoMapper;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

  @Resource private DemoMapper demoMapper;

  public int deleteByPrimaryKey(Long id) {
    return demoMapper.deleteByPrimaryKey(id);
  }

  public int insert(Demo demo) {
    return demoMapper.insert(demo);
  }

  public int insertOrUpdate(Demo demo) {
    return demoMapper.insertOrUpdate(demo);
  }

  public int insertOrUpdateSelective(Demo demo) {
    return demoMapper.insertOrUpdateSelective(demo);
  }

  public int insertSelective(Demo demo) {
    return demoMapper.insertSelective(demo);
  }

  public Demo selectByPrimaryKey(Long id) {
    return demoMapper.selectByPrimaryKey(id);
  }

  public int updateByPrimaryKeySelective(Demo demo) {
    return demoMapper.updateByPrimaryKeySelective(demo);
  }

  public int updateByPrimaryKey(Demo demo) {
    return demoMapper.updateByPrimaryKey(demo);
  }

  public int updateBatch(List<Demo> list) {
    return demoMapper.updateBatch(list);
  }

  public int updateBatchSelective(List<Demo> list) {
    return demoMapper.updateBatchSelective(list);
  }

  public int batchInsert(List<Demo> list) {
    return demoMapper.batchInsert(list);
  }
}
