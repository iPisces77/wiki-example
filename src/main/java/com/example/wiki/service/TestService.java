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
}
