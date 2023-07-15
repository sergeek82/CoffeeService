package ru.my.kafka.kafkaspring.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.my.kafka.kafkaspring.model.CoffeeStore;

public interface CoffeeStoreRepository extends JpaRepository<CoffeeStore, UUID> {

}
