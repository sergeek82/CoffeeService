package ru.factory.coffee.service;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.factory.coffee.model.Store;
import ru.factory.coffee.repository.CoffeeStoreRepository;

@Service
@RequiredArgsConstructor
public class KafkaListenerService {

  private final CoffeeStoreRepository repository;

  @KafkaListener(topics = "PurchaseCoffeeTopic", groupId = "coffee-plant-1")
  @Transactional
  public void readMessage(ConsumerRecord<String, Store> record) {
    Store store = record.value();
    repository.save(store);
  }

}
