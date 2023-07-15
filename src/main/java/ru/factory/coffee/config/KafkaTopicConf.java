package ru.factory.coffee.config;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaTopicConf {

  @Bean
  public KafkaAdmin kafkaAdmin(@Value("${bootstrap.servers}") String bootstrapAddress) {
    Map<String, Object> conf = new HashMap<>();
    conf.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
    return new KafkaAdmin(conf);
  }

  @Bean
  public NewTopic newTopic() {
    return new NewTopic("PurchaseCoffeeTopic", 1, (short) 1);
  }
}
