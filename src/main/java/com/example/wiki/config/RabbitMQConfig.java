package com.example.wiki.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 付海鑫
 * @date 2021年11月16日 9:20
 */
@Configuration
public class RabbitMQConfig {
  // 创建 Queue
  @Bean
  public Queue queue() {
    return new Queue(
        "Vote", // Queue 名字
        true, // durable: 是否持久化
        false, // exclusive: 是否排它
        false); // autoDelete: 是否自动删除
  }

  // 创建 Topic Exchange
  @Bean
  public TopicExchange exchange() {
    return new TopicExchange(
        "Vote_Exchange",
        true, // durable: 是否持久化
        false); // exclusive: 是否排它
  }

  // 创建 Binding
  // Exchange：Demo02Message.EXCHANGE
  // Routing key：Demo02Message.ROUTING_KEY
  // Queue：Demo02Message.QUEUE
  @Bean
  public Binding binding() {
    return BindingBuilder.bind(queue()).to(exchange()).with("VOTE_TOPIC");
  }
}
