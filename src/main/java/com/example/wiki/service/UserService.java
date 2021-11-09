package com.example.wiki.service;

import com.example.wiki.domain.User;
import com.example.wiki.mapper.UserMapper;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Resource private UserMapper userMapper;

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
}
