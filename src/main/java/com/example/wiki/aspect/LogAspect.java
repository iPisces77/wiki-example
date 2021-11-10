package com.example.wiki.aspect;

import cn.hutool.core.lang.Snowflake;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class LogAspect {
  private static final Logger LOG = LoggerFactory.getLogger(LogAspect.class);
  private final ObjectMapper mapper;
  @Resource private Snowflake snowFlake;

  public LogAspect(ObjectMapper mapper) {
    this.mapper = mapper;
  }

  /** 定义一个切点 */
  @Pointcut("execution(public * com.example.*.controller..*Controller.*(..))")
  public void controllerPointcut() {}

  @Before("controllerPointcut()")
  public void doBefore(JoinPoint joinPoint) throws Throwable {

    // 增加日志流水号
    MDC.put("LOG_ID", String.valueOf(snowFlake.nextId()));

    // 开始打印请求日志
    ServletRequestAttributes attributes =
        (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    HttpServletRequest request = attributes.getRequest();
    Signature signature = joinPoint.getSignature();
    String name = signature.getName();

    // 打印请求信息
    LOG.info("------------- 开始 -------------");
    LOG.info("请求地址: {} {}", request.getRequestURL().toString(), request.getMethod());
    LOG.info("类名方法: {}.{}", signature.getDeclaringTypeName(), name);
    LOG.info("远程地址: {}", request.getRemoteAddr());
  }

  @Around("controllerPointcut()")
  public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    long startTime = System.currentTimeMillis();
    Object result = proceedingJoinPoint.proceed();
    // 排除字段，敏感字段或太长的字段不显示
    return result;
  }
}
