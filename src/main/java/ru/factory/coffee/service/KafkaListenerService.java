package ru.my.kafka.kafkaspring.service;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.my.kafka.kafkaspring.model.CoffeeStore;
import ru.my.kafka.kafkaspring.repository.CoffeeStoreRepository;

@Service
@RequiredArgsConstructor
public class KafkaListenerService {

  private final CoffeeStoreRepository repository;

  @KafkaListener(topics = "PurchaseCoffeeTopic")
  public void readMessage(ConsumerRecord<String, CoffeeStore> record) {
    CoffeeStore coffeeStore = record.value();
    repository.save(coffeeStore);
  }

}
