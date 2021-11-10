package com.example.wiki.mapper;

import com.example.wiki.domain.Ebook;
import com.example.wiki.request.EBookQueryRequest;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EbookMapper {
  /**
   * delete by primary key
   *
   * @param id primaryKey
   * @return deleteCount
   */
  int deleteByPrimaryKey(Long id);

  /**
   * insert ebook to table
   *
   * @param ebook the ebook
   * @return insert count
   */
  int insert(Ebook ebook);

  int insertOrUpdate(Ebook ebook);

  int insertOrUpdateSelective(Ebook ebook);

  /**
   * insert ebook to table selective
   *
   * @param ebook the ebook
   * @return insert count
   */
  int insertSelective(Ebook ebook);

  /**
   * select by primary key
   *
   * @param id primary key
   * @return object by primary key
   */
  Ebook selectByPrimaryKey(Long id);

  /**
   * update ebook selective
   *
   * @param ebook the updated ebook
   * @return update count
   */
  int updateByPrimaryKeySelective(Ebook ebook);

  /**
   * update ebook
   *
   * @param ebook the updated ebook
   * @return update count
   */
  int updateByPrimaryKey(Ebook ebook);

  int updateBatch(@Param("list") List<Ebook> list);

  int updateBatchSelective(@Param("list") List<Ebook> list);

  int batchInsert(@Param("list") List<Ebook> list);

  List<Ebook> list(@Param("request") EBookQueryRequest request);
}
