package com.example.wiki.service;

import com.example.wiki.websocket.WebSocketServer;
import org.slf4j.MDC;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author 付海鑫
 * @date 2021年11月15日 21:39
 */
@Service
public class WebSocketService {
  public final WebSocketServer webSocketServer;

  public WebSocketService(WebSocketServer webSocketServer) {
    this.webSocketServer = webSocketServer;
  }

  @Async
  public void sendInfo(String message, String logId) {
    MDC.put("LOG_ID", logId);
    webSocketServer.sendInfo(message);
  }
}
