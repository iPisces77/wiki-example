package com.example.wiki.controller;

import com.example.wiki.request.UserLoginRequest;
import com.example.wiki.request.UserPasswordRequest;
import com.example.wiki.request.UserQueryRequest;
import com.example.wiki.request.UserSaveRequest;
import com.example.wiki.response.CommonResponse;
import com.example.wiki.response.PageResponse;
import com.example.wiki.response.UserLoginResponse;
import com.example.wiki.response.UserQueryResponse;
import com.example.wiki.service.UserService;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.DigestUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 付海鑫
 * @date 2021年11月09日 15:54
 */
@RestController
@RequestMapping("/user")
public class UserController {
  private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
  private final RedisTemplate redisTemplate;
  private final UserService userService;

  public UserController(UserService ebookService, RedisTemplate redisTemplate) {
    this.userService = ebookService;
    this.redisTemplate = redisTemplate;
  }

  @GetMapping("/list")
  public CommonResponse<PageResponse<UserQueryResponse>> list(@Validated UserQueryRequest request) {
    var list = userService.list(request);
    var ebookCommonResponse = new CommonResponse<PageResponse<UserQueryResponse>>();
    ebookCommonResponse.setContent(list);
    return ebookCommonResponse;
  }
  /** 保存 */
  @PostMapping("/save")
  public CommonResponse<? extends Object> save(@RequestBody @Validated UserSaveRequest request) {
    request.setPassword(
        DigestUtils.md5DigestAsHex(request.getPassword().getBytes(StandardCharsets.UTF_8)));

    userService.save(request);
    return new CommonResponse<>();
  }

  @DeleteMapping("/delete/{id}")
  public CommonResponse<? extends Object> delete(@PathVariable(value = "id") Long id) {
    var commonResponse = new CommonResponse<>();
    userService.deleteByPrimaryKey(id);
    return commonResponse;
  }

  @PostMapping("/reset-password")
  public CommonResponse<? extends Object> resetPassword(
      @RequestBody @Validated UserPasswordRequest request) {
    request.setPassword(
        DigestUtils.md5DigestAsHex(request.getPassword().getBytes(StandardCharsets.UTF_8)));
    userService.resetPassword(request);
    return new CommonResponse<>();
  }

  @PostMapping("/login")
  public CommonResponse<UserLoginResponse> login(@RequestBody @Validated UserLoginRequest request) {

    var password =
        DigestUtils.md5DigestAsHex(request.getPassword().getBytes(StandardCharsets.UTF_8));
    LOG.info("密码为" + password);
    request.setPassword(password);
    var commonResponse = new CommonResponse<UserLoginResponse>();
    var login = userService.login(request);
    var token = UUID.randomUUID().toString();
    LOG.info("生成Token并存入redis:{}", token);
    login.setToken(token);
    redisTemplate.opsForValue().set(token, login, 3600 * 24, TimeUnit.SECONDS);
    commonResponse.setContent(login);
    return commonResponse;
  }

  @GetMapping("/logout/{token}")
  public CommonResponse<? extends Object> logout(@PathVariable(value = "token") String token) {
    var commonResponse = new CommonResponse<>();
    redisTemplate.delete(token);
    return commonResponse;
  }
}
