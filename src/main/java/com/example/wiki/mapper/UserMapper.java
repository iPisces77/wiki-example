package com.example.wiki.mapper;

import com.example.wiki.domain.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
  /**
   * delete by primary key
   *
   * @param id primaryKey
   * @return deleteCount
   */
  int deleteByPrimaryKey(Long id);

  /**
   * insert user to table
   *
   * @param user the user
   * @return insert count
   */
  int insert(User user);

  int insertOrUpdate(User user);

  int insertOrUpdateSelective(User user);

  /**
   * insert user to table selective
   *
   * @param user the user
   * @return insert count
   */
  int insertSelective(User user);

  /**
   * select by primary key
   *
   * @param id primary key
   * @return object by primary key
   */
  User selectByPrimaryKey(Long id);

  /**
   * update user selective
   *
   * @param user the updated user
   * @return update count
   */
  int updateByPrimaryKeySelective(User user);

  /**
   * update user
   *
   * @param user the updated user
   * @return update count
   */
  int updateByPrimaryKey(User user);

  int updateBatch(@Param("list") List<User> list);

  int updateBatchSelective(@Param("list") List<User> list);

  int batchInsert(@Param("list") List<User> list);
}
