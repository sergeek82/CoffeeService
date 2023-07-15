package ru.my.kafka.kafkaspring.config;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.yaml.snakeyaml.serializer.Serializer;

@Configuration
public class KafkaProducerConf {

  @Value("bootstrap.server")
  private String bootstrapAddress;

  @Bean
  public ProducerFactory<String, String> producerFactory() {

    Map<String, Object> prodConf = new HashMap<>();
    prodConf.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
    prodConf.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, Serializer.class);
    prodConf.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, Serializer.class);
    return new DefaultKafkaProducerFactory<>(prodConf);
  }

  @Bean
  public KafkaTemplate<String, String> kafkaTemplate() {
    return new KafkaTemplate<>(producerFactory());
  }
}
