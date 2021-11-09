package com.example.wiki.service;

import com.example.wiki.domain.Category;
import com.example.wiki.mapper.CategoryMapper;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

  @Resource private CategoryMapper categoryMapper;

  public int deleteByPrimaryKey(Long id) {
    return categoryMapper.deleteByPrimaryKey(id);
  }

  public int insert(Category category) {
    return categoryMapper.insert(category);
  }

  public int insertOrUpdate(Category category) {
    return categoryMapper.insertOrUpdate(category);
  }

  public int insertOrUpdateSelective(Category category) {
    return categoryMapper.insertOrUpdateSelective(category);
  }

  public int insertSelective(Category category) {
    return categoryMapper.insertSelective(category);
  }

  public Category selectByPrimaryKey(Long id) {
    return categoryMapper.selectByPrimaryKey(id);
  }

  public int updateByPrimaryKeySelective(Category category) {
    return categoryMapper.updateByPrimaryKeySelective(category);
  }

  public int updateByPrimaryKey(Category category) {
    return categoryMapper.updateByPrimaryKey(category);
  }

  public int updateBatch(List<Category> list) {
    return categoryMapper.updateBatch(list);
  }

  public int updateBatchSelective(List<Category> list) {
    return categoryMapper.updateBatchSelective(list);
  }

  public int batchInsert(List<Category> list) {
    return categoryMapper.batchInsert(list);
  }
}
