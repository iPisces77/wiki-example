package com.example.wiki.service;

import com.example.wiki.domain.EbookSnapshot;
import com.example.wiki.mapper.EbookSnapshotMapper;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class EbookSnapshotService {

  @Resource private EbookSnapshotMapper ebookSnapshotMapper;

  public int deleteByPrimaryKey(Long id) {
    return ebookSnapshotMapper.deleteByPrimaryKey(id);
  }

  public int insert(EbookSnapshot ebookSnapshot) {
    return ebookSnapshotMapper.insert(ebookSnapshot);
  }

  public int insertOrUpdate(EbookSnapshot ebookSnapshot) {
    return ebookSnapshotMapper.insertOrUpdate(ebookSnapshot);
  }

  public int insertOrUpdateSelective(EbookSnapshot ebookSnapshot) {
    return ebookSnapshotMapper.insertOrUpdateSelective(ebookSnapshot);
  }

  public int insertSelective(EbookSnapshot ebookSnapshot) {
    return ebookSnapshotMapper.insertSelective(ebookSnapshot);
  }

  public EbookSnapshot selectByPrimaryKey(Long id) {
    return ebookSnapshotMapper.selectByPrimaryKey(id);
  }

  public int updateByPrimaryKeySelective(EbookSnapshot ebookSnapshot) {
    return ebookSnapshotMapper.updateByPrimaryKeySelective(ebookSnapshot);
  }

  public int updateByPrimaryKey(EbookSnapshot ebookSnapshot) {
    return ebookSnapshotMapper.updateByPrimaryKey(ebookSnapshot);
  }

  public int updateBatch(List<EbookSnapshot> list) {
    return ebookSnapshotMapper.updateBatch(list);
  }

  public int updateBatchSelective(List<EbookSnapshot> list) {
    return ebookSnapshotMapper.updateBatchSelective(list);
  }

  public int batchInsert(List<EbookSnapshot> list) {
    return ebookSnapshotMapper.batchInsert(list);
  }
}
