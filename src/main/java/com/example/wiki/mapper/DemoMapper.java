package com.example.wiki.mapper;

import com.example.wiki.domain.Demo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DemoMapper {
  /**
   * delete by primary key
   *
   * @param id primaryKey
   * @return deleteCount
   */
  int deleteByPrimaryKey(Long id);

  /**
   * insert demo to table
   *
   * @param demo the demo
   * @return insert count
   */
  int insert(Demo demo);

  int insertOrUpdate(Demo demo);

  int insertOrUpdateSelective(Demo demo);

  /**
   * insert demo to table selective
   *
   * @param demo the demo
   * @return insert count
   */
  int insertSelective(Demo demo);

  /**
   * select by primary key
   *
   * @param id primary key
   * @return object by primary key
   */
  Demo selectByPrimaryKey(Long id);

  /**
   * update demo selective
   *
   * @param demo the updated demo
   * @return update count
   */
  int updateByPrimaryKeySelective(Demo demo);

  /**
   * update demo
   *
   * @param demo the updated demo
   * @return update count
   */
  int updateByPrimaryKey(Demo demo);

  int updateBatch(@Param("list") List<Demo> list);

  int updateBatchSelective(@Param("list") List<Demo> list);

  int batchInsert(@Param("list") List<Demo> list);
}
