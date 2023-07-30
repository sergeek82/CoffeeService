package ru.factory.coffee.service;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.factory.coffee.dto.StoreFullDto;

@Component
@RequiredArgsConstructor
public class KafkaConsumer {

  private final StoreService storeService;

  @KafkaListener(topics = "PurchaseCoffeeTopic", groupId = "coffee-plant-1")
  public void readMessage(ConsumerRecord<String, StoreFullDto> record) {
    StoreFullDto storeFullDto = record.value();
    storeService.addRecord(storeFullDto);
  }

}
