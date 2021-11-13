package com.example.wiki.service;

import static com.example.wiki.exception.BusinessExceptionCode.LOGIN_USER_ERROR;
import static com.example.wiki.exception.BusinessExceptionCode.USER_LOGIN_NAME_EXIST;

import cn.hutool.core.lang.Snowflake;
import com.example.wiki.converter.UserConverter;
import com.example.wiki.domain.User;
import com.example.wiki.exception.BusinessException;
import com.example.wiki.mapper.UserMapper;
import com.example.wiki.request.UserLoginRequest;
import com.example.wiki.request.UserPasswordRequest;
import com.example.wiki.request.UserQueryRequest;
import com.example.wiki.request.UserSaveRequest;
import com.example.wiki.response.PageResponse;
import com.example.wiki.response.UserLoginResponse;
import com.example.wiki.response.UserQueryResponse;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import java.util.List;
import java.util.Objects;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
  private final UserConverter converter;
  private final Snowflake snowflake;
  @Resource private UserMapper userMapper;

  public UserService(UserConverter converter, Snowflake snowflake) {
    this.converter = converter;
    this.snowflake = snowflake;
  }

  public int deleteByPrimaryKey(Long id) {
    return userMapper.deleteByPrimaryKey(id);
  }

  public int insert(User user) {
    return userMapper.insert(user);
  }

  public int insertOrUpdate(User user) {
    return userMapper.insertOrUpdate(user);
  }

  public int insertOrUpdateSelective(User user) {
    return userMapper.insertOrUpdateSelective(user);
  }

  public int insertSelective(User user) {
    return userMapper.insertSelective(user);
  }

  public User selectByPrimaryKey(Long id) {
    return userMapper.selectByPrimaryKey(id);
  }

  public int updateByPrimaryKeySelective(User user) {
    return userMapper.updateByPrimaryKeySelective(user);
  }

  public int updateByPrimaryKey(User user) {
    return userMapper.updateByPrimaryKey(user);
  }

  public int updateBatch(List<User> list) {
    return userMapper.updateBatch(list);
  }

  public int updateBatchSelective(List<User> list) {
    return userMapper.updateBatchSelective(list);
  }

  public int batchInsert(List<User> list) {
    return userMapper.batchInsert(list);
  }

  public PageResponse<UserQueryResponse> list(UserQueryRequest request) {
    PageMethod.startPage(request.getPage(), request.getSize());
    var list = userMapper.list(request);
    var userPageInfo = new PageInfo<>(list);
    var total = userPageInfo.getTotal();
    LOG.info("总行数:{}", total);
    var pages = userPageInfo.getPages();
    LOG.info("总页数:{}", pages);
    var userResponses = converter.do2voList(list);
    var userResponsePageResponse = new PageResponse<UserQueryResponse>();
    userResponsePageResponse.setList(userResponses);
    userResponsePageResponse.setTotal(total);
    return userResponsePageResponse;
  }

  public void save(UserSaveRequest request) {
    var user = converter.vo2Do(request);
    if (Objects.nonNull(user.getId())) {
      user.setLoginName(null);
      user.setPassword(null);
      userMapper.updateByPrimaryKeySelective(user);
    } else {
      if (Objects.isNull(selectByLoginName(request.getLoginName()))) {

        var id = snowflake.nextId();
        user.setId(id);
        userMapper.insertSelective(user);
      } else {
        throw new BusinessException(USER_LOGIN_NAME_EXIST);
      }
    }
  }

  public User selectByLoginName(String loginName) {
    return userMapper.selectByLoginName(loginName);
  }

  public void resetPassword(UserPasswordRequest request) {
    var user = converter.vo2Do(request);
    userMapper.updateByPrimaryKeySelective(user);
  }

  public UserLoginResponse login(UserLoginRequest request) {
    var user = selectByLoginName(request.getLoginName());
    if (Objects.nonNull(user)) {
      if (user.getPassword().equals(request.getPassword())) {
        return converter.do2Loginvo(user);
      } else {
        LOG.info("用户名不存在, {}", request.getLoginName());
        throw new BusinessException(LOGIN_USER_ERROR);
      }

    } else {
      LOG.info("用户名不存在, {}", request.getLoginName());
      throw new BusinessException(LOGIN_USER_ERROR);
    }
  }
}
