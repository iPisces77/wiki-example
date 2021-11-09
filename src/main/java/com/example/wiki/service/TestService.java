package com.example.wiki.service;

import com.example.wiki.domain.Test;
import com.example.wiki.mapper.TestMapper;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author 付海鑫
 * @date 2021年11月09日 13:50
 */
@Service
public class TestService {

  private final TestMapper testMapper;

  public TestService(TestMapper testMapper) {
    this.testMapper = testMapper;
  }

  public List<Test> list() {
    return testMapper.list();
  }

  public int deleteByPrimaryKey(Long id) {
    return testMapper.deleteByPrimaryKey(id);
  }

  public int insert(Test test) {
    return testMapper.insert(test);
  }

  public int insertOrUpdate(Test test) {
    return testMapper.insertOrUpdate(test);
  }

  public int insertOrUpdateSelective(Test test) {
    return testMapper.insertOrUpdateSelective(test);
  }

  public int insertSelective(Test test) {
    return testMapper.insertSelective(test);
  }

  public Test selectByPrimaryKey(Long id) {
    return testMapper.selectByPrimaryKey(id);
  }

  public int updateByPrimaryKeySelective(Test test) {
    return testMapper.updateByPrimaryKeySelective(test);
  }

  public int updateByPrimaryKey(Test test) {
    return testMapper.updateByPrimaryKey(test);
  }

  public int updateBatch(List<Test> list) {
    return testMapper.updateBatch(list);
  }

  public int updateBatchSelective(List<Test> list) {
    return testMapper.updateBatchSelective(list);
  }

  public int batchInsert(List<Test> list) {
    return testMapper.batchInsert(list);
  }
}

