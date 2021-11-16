package com.example.wiki.mapper;

import com.example.wiki.domain.EbookSnapshot;
import com.example.wiki.domain.Statistic;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EbookSnapshotMapper {
  /**
   * delete by primary key
   *
   * @param id primaryKey
   * @return deleteCount
   */
  int deleteByPrimaryKey(Long id);

  /**
   * insert ebookSnapshot to table
   *
   * @param ebookSnapshot the ebookSnapshot
   * @return insert count
   */
  int insert(EbookSnapshot ebookSnapshot);

  int insertOrUpdate(EbookSnapshot ebookSnapshot);

  int insertOrUpdateSelective(EbookSnapshot ebookSnapshot);

  /**
   * insert ebookSnapshot to table selective
   *
   * @param ebookSnapshot the ebookSnapshot
   * @return insert count
   */
  int insertSelective(EbookSnapshot ebookSnapshot);

  /**
   * select by primary key
   *
   * @param id primary key
   * @return object by primary key
   */
  EbookSnapshot selectByPrimaryKey(Long id);

  /**
   * update ebookSnapshot selective
   *
   * @param ebookSnapshot the updated ebookSnapshot
   * @return update count
   */
  int updateByPrimaryKeySelective(EbookSnapshot ebookSnapshot);

  /**
   * update ebookSnapshot
   *
   * @param ebookSnapshot the updated ebookSnapshot
   * @return update count
   */
  int updateByPrimaryKey(EbookSnapshot ebookSnapshot);

  int updateBatch(@Param("list") List<EbookSnapshot> list);

  int updateBatchSelective(@Param("list") List<EbookSnapshot> list);

  int batchInsert(@Param("list") List<EbookSnapshot> list);

  void genSnapshot();

  List<Statistic> getStatistic();
}
