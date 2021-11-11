package com.example.wiki.service;

import cn.hutool.core.lang.Snowflake;
import com.example.wiki.converter.CategoryConverter;
import com.example.wiki.domain.Category;
import com.example.wiki.mapper.CategoryMapper;
import com.example.wiki.request.CategoryQueryRequest;
import com.example.wiki.request.CategorySaveRequest;
import com.example.wiki.response.CategoryQueryResponse;
import com.example.wiki.response.PageResponse;
import com.github.pagehelper.PageInfo;
import java.util.List;
import java.util.Objects;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
  private static final Logger LOG = LoggerFactory.getLogger(CategoryService.class);
  private final CategoryConverter converter;
  private final Snowflake snowflake;
  @Resource private CategoryMapper categoryMapper;

  public CategoryService(CategoryConverter converter, Snowflake snowflake) {
    this.converter = converter;
    this.snowflake = snowflake;
  }

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

  public void save(CategorySaveRequest request) {

    var ebook = converter.vo2Do(request);
    if (Objects.nonNull(ebook.getId())) {

      categoryMapper.updateByPrimaryKey(ebook);
    } else {
      var id = snowflake.nextId();
      ebook.setId(id);
      categoryMapper.insertSelective(ebook);
    }
  }

  public PageResponse<CategoryQueryResponse> list(CategoryQueryRequest request) {
    var list = categoryMapper.list(request);

    var categoryPageInfo = new PageInfo<Category>(list);
    var total = categoryPageInfo.getTotal();
    LOG.info("总行数:{}", total);
    var pages = categoryPageInfo.getPages();
    LOG.info("总页数:{}", pages);
    var categoryResponses = converter.do2voList(list);
    var categoryResponsePageResponse = new PageResponse<CategoryQueryResponse>();
    categoryResponsePageResponse.setList(categoryResponses);
    categoryResponsePageResponse.setTotal(total);
    return categoryResponsePageResponse;
  }

  public List<CategoryQueryResponse> all() {

    return converter.do2voList((categoryMapper.all()));
  }
}
