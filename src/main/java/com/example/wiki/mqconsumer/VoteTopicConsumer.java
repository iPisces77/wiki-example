package com.example.wiki.mqconsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "Vote")
public class VoteTopicConsumer {

  private static final Logger LOG = LoggerFactory.getLogger(VoteTopicConsumer.class);

  @RabbitHandler
  public void onMessage(String message) {
    LOG.info("MQ收到消息：{}", message);
  }
}
