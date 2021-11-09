package com.example.wiki.mapper;

import com.example.wiki.domain.Category;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CategoryMapper {
  /**
   * delete by primary key
   *
   * @param id primaryKey
   * @return deleteCount
   */
  int deleteByPrimaryKey(Long id);

  /**
   * insert category to table
   *
   * @param category the category
   * @return insert count
   */
  int insert(Category category);

  int insertOrUpdate(Category category);

  int insertOrUpdateSelective(Category category);

  /**
   * insert category to table selective
   *
   * @param category the category
   * @return insert count
   */
  int insertSelective(Category category);

  /**
   * select by primary key
   *
   * @param id primary key
   * @return object by primary key
   */
  Category selectByPrimaryKey(Long id);

  /**
   * update category selective
   *
   * @param category the updated category
   * @return update count
   */
  int updateByPrimaryKeySelective(Category category);

  /**
   * update category
   *
   * @param category the updated category
   * @return update count
   */
  int updateByPrimaryKey(Category category);

  int updateBatch(@Param("list") List<Category> list);

  int updateBatchSelective(@Param("list") List<Category> list);

  int batchInsert(@Param("list") List<Category> list);
}
