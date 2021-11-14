package com.example.wiki.converter;

import com.example.wiki.domain.User;
import com.example.wiki.request.UserPasswordRequest;
import com.example.wiki.request.UserSaveRequest;
import com.example.wiki.response.UserLoginResponse;
import com.example.wiki.response.UserQueryResponse;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author 付海鑫
 * @date 2021年11月09日 16:58
 */
@Mapper(componentModel = "spring")
public interface UserConverter {
  @Mapping(source = "id", target = "id", resultType = String.class)
  UserQueryResponse do2vo(User var1);

  @Mapping(source = "id", target = "id", resultType = String.class)
  @Mapping(target = "token", ignore = true)
  UserLoginResponse do2Loginvo(User var1);

  User vo2Do(UserQueryResponse var1);

  User vo2Do(UserSaveRequest request);

  List<UserQueryResponse> do2voList(List<User> userList);

  @Mapping(ignore = true, target = "loginName")
  @Mapping(ignore = true, target = "name")
  User vo2Do(UserPasswordRequest request);
}
