package com.example.wiki.service;

import static com.example.wiki.exception.BusinessExceptionCode.VOTE_REPEAT;

import cn.hutool.core.lang.Snowflake;
import com.example.wiki.converter.ContentConverter;
import com.example.wiki.converter.DocConverter;
import com.example.wiki.domain.Doc;
import com.example.wiki.exception.BusinessException;
import com.example.wiki.mapper.ContentMapper;
import com.example.wiki.mapper.DocMapper;
import com.example.wiki.request.DocQueryRequest;
import com.example.wiki.request.DocSaveRequest;
import com.example.wiki.response.DocQueryResponse;
import com.example.wiki.response.PageResponse;
import com.example.wiki.utils.RequestContext;
import com.github.pagehelper.PageInfo;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DocService {
  private static final Logger LOG = LoggerFactory.getLogger(DocService.class);
  private final DocConverter converter;
  private final Snowflake snowflake;
  private final DocMapper docMapper;
  private final ContentMapper contentMapper;
  private final ContentConverter contentConverter;
  private final RedisTemplate redisTemplate;
  private final WebSocketService webSocketService;
  private final RabbitTemplate rabbitTemplate;

  public DocService(
      DocConverter converter,
      Snowflake snowflake,
      DocMapper docMapper,
      ContentConverter contentConverter,
      ContentMapper contentMapper,
      RedisTemplate redisTemplate,
      WebSocketService webSocketService,
      RabbitTemplate rabbitTemplate) {
    this.converter = converter;
    this.snowflake = snowflake;
    this.docMapper = docMapper;
    this.contentConverter = contentConverter;
    this.contentMapper = contentMapper;
    this.redisTemplate = redisTemplate;

    this.webSocketService = webSocketService;
    this.rabbitTemplate = rabbitTemplate;
  }

  public int deleteByPrimaryKey(Long id) {
    return docMapper.deleteByPrimaryKey(id);
  }

  public int deleteByPrimaryKey(List<String> ids) {
    return docMapper.deleteByPrimaryKeys(ids);
  }

  public int insert(Doc doc) {
    return docMapper.insert(doc);
  }

  public int insertOrUpdate(Doc doc) {
    return docMapper.insertOrUpdate(doc);
  }

  public int insertOrUpdateSelective(Doc doc) {
    return docMapper.insertOrUpdateSelective(doc);
  }

  public int insertSelective(Doc doc) {
    return docMapper.insertSelective(doc);
  }

  public Doc selectByPrimaryKey(Long id) {
    return docMapper.selectByPrimaryKey(id);
  }

  public int updateByPrimaryKeySelective(Doc doc) {
    return docMapper.updateByPrimaryKeySelective(doc);
  }

  public int updateByPrimaryKey(Doc doc) {
    return docMapper.updateByPrimaryKey(doc);
  }

  public int updateBatch(List<Doc> list) {
    return docMapper.updateBatch(list);
  }

  public int updateBatchSelective(List<Doc> list) {
    return docMapper.updateBatchSelective(list);
  }

  public int batchInsert(List<Doc> list) {
    return docMapper.batchInsert(list);
  }

  public void save(DocSaveRequest request) {

    var ebook = converter.vo2Do(request);
    var content = contentConverter.vo2Do(request);

    if (Objects.nonNull(ebook.getId())) {
      docMapper.updateByPrimaryKey(ebook);
      var i = contentMapper.updateByPrimaryKey(content);
      if (i == 0) {
        contentMapper.insert(content);
      }
    } else {
      var id = snowflake.nextId();
      ebook.setId(id);
      content.setId(ebook.getId());
      contentMapper.insert(content);
      docMapper.insertSelective(ebook);
    }
  }

  public PageResponse<DocQueryResponse> list(DocQueryRequest request) {
    var list = docMapper.list(request);

    var docPageInfo = new PageInfo<>(list);
    var total = docPageInfo.getTotal();
    LOG.info("总行数:{}", total);
    var pages = docPageInfo.getPages();
    LOG.info("总页数:{}", pages);
    var docResponses = converter.do2voList(list);
    var docResponsePageResponse = new PageResponse<DocQueryResponse>();
    docResponsePageResponse.setList(docResponses);
    docResponsePageResponse.setTotal(total);
    return docResponsePageResponse;
  }

  public List<DocQueryResponse> all(Long ebookId) {

    return converter.do2voList((docMapper.all(ebookId)));
  }

  @Transactional(isolation = Isolation.READ_COMMITTED)
  public String findContent(Long id) {
    var content = contentMapper.selectByPrimaryKey(id);
    docMapper.selectByPrimaryKeyForUpdate(id);
    docMapper.increaseViewCount(id);
    if (Objects.nonNull(content)) {
      var contentContent = content.getContent();
      if (Objects.nonNull(contentContent)) {
        return contentContent;
      }
    }
    return "";
  }

  @Transactional(isolation = Isolation.READ_COMMITTED)
  public void vote(Long id) {
    var ip = RequestContext.getRemoteAddr();
    var key = "DOC_VOTE_" + id + "_" + ip;
    if (redisTemplate.hasKey(key)) {
      throw new BusinessException(VOTE_REPEAT);
    } else {
      var doc = docMapper.selectByPrimaryKeyForUpdate(id);
      docMapper.increaseVoteCount(id);
      redisTemplate.opsForValue().set(key, key, 1, TimeUnit.DAYS);
      // 推送消息
      var logId = MDC.get("LOG_ID");
      //      webSocketService.sendInfo("【" + doc.getName() + "】被点赞！", logId);
      rabbitTemplate.convertAndSend("Vote_Exchange", "VOTE_TOPIC", "【" + doc.getName() + "】被点赞！");
    }
  }

  public void updateEbookInfo() {
    docMapper.updateEBookInfo();
  }
}
