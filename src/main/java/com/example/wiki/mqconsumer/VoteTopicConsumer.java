package com.example.wiki.mqconsumer;

import com.example.wiki.websocket.WebSocketServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "Vote")
public class VoteTopicConsumer {

  private static final Logger LOG = LoggerFactory.getLogger(VoteTopicConsumer.class);
  private final WebSocketServer webSocketServer;

  public VoteTopicConsumer(WebSocketServer webSocketServer) {
    this.webSocketServer = webSocketServer;
  }

  @RabbitHandler
  public void onMessage(String message) {
    LOG.info("MQ收到消息：{}", message);
    webSocketServer.sendInfo(message);
  }
}
