package com.example.wiki.mapper;

import com.example.wiki.domain.Test;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TestMapper {

  /**
   * delete by primary key
   *
   * @param id primaryKey
   * @return deleteCount
   */
  int deleteByPrimaryKey(Long id);

  /**
   * insert test to table
   *
   * @param test the test
   * @return insert count
   */
  int insert(Test test);

  int insertOrUpdate(Test test);

  int insertOrUpdateSelective(Test test);

  /**
   * insert test to table selective
   *
   * @param test the test
   * @return insert count
   */
  int insertSelective(Test test);

  /**
   * select by primary key
   *
   * @param id primary key
   * @return object by primary key
   */
  Test selectByPrimaryKey(Long id);

  /**
   * update test selective
   *
   * @param test the updated test
   * @return update count
   */
  int updateByPrimaryKeySelective(Test test);

  /**
   * update test
   *
   * @param test the updated test
   * @return update count
   */
  int updateByPrimaryKey(Test test);

  int updateBatch(@Param("list") List<Test> list);

  int updateBatchSelective(@Param("list") List<Test> list);

  int batchInsert(@Param("list") List<Test> list);

  List<Test> list();
}
