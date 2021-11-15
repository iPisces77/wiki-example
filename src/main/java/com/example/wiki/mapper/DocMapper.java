package com.example.wiki.mapper;

import com.example.wiki.domain.Doc;
import com.example.wiki.request.DocQueryRequest;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DocMapper {
  void increaseViewCount(Long id);

  /**
   * delete by primary key
   *
   * @param id primaryKey
   * @return deleteCount
   */
  int deleteByPrimaryKey(Long id);

  /**
   * insert record to table
   *
   * @param doc the record
   * @return insert count
   */
  int insert(Doc doc);

  int insertOrUpdate(Doc doc);

  int insertOrUpdateSelective(Doc doc);

  /**
   * insert record to table selective
   *
   * @param doc the record
   * @return insert count
   */
  int insertSelective(Doc doc);

  /**
   * select by primary key
   *
   * @param id primary key
   * @return object by primary key
   */
  Doc selectByPrimaryKey(Long id);

  /**
   * update record selective
   *
   * @param doc the updated record
   * @return update count
   */
  int updateByPrimaryKeySelective(Doc doc);

  /**
   * update record
   *
   * @param doc the updated record
   * @return update count
   */
  int updateByPrimaryKey(Doc doc);

  int updateBatch(@Param("list") List<Doc> list);

  int updateBatchSelective(@Param("list") List<Doc> list);

  int batchInsert(@Param("list") List<Doc> list);

  List<Doc> list(@Param("request") DocQueryRequest request);

  List<Doc> all(Long ebookId);

  int deleteByPrimaryKeys(List<String> ids);

  Doc selectByPrimaryKeyForUpdate(Long id);

  void increaseVoteCount(Long id);

  void updateEBookInfo();
}
