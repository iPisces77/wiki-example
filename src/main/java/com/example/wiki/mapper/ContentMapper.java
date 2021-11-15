package com.example.wiki.mapper;

import com.example.wiki.domain.Content;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ContentMapper {
  /**
   * delete by primary key
   *
   * @param id primaryKey
   * @return deleteCount
   */
  int deleteByPrimaryKey(Long id);

  /**
   * insert content to table
   *
   * @param content the content
   * @return insert count
   */
  int insert(Content content);

  int insertOrUpdate(Content content);

  int insertOrUpdateSelective(Content content);

  /**
   * insert content to table selective
   *
   * @param content the content
   * @return insert count
   */
  int insertSelective(Content content);

  /**
   * select by primary key
   *
   * @param id primary key
   * @return object by primary key
   */
  Content selectByPrimaryKey(Long id);

  /**
   * update content selective
   *
   * @param content the updated content
   * @return update count
   */
  int updateByPrimaryKeySelective(Content content);

  /**
   * update content
   *
   * @param content the updated content
   * @return update count
   */
  int updateByPrimaryKey(Content content);

  int updateBatch(@Param("list") List<Content> list);

  int updateBatchSelective(@Param("list") List<Content> list);

  int batchInsert(@Param("list") List<Content> list);


}
