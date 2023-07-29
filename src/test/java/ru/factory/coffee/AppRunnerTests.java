package ru.factory.coffee;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest
@Testcontainers
class AppRunnerTests {

  @Container
  @ServiceConnection
  private final static MySQLContainer<?> mySqlContainer = new MySQLContainer("mysql:8.0.28")
      .withDatabaseName("test-container")
      .withUsername("root")
      .withPassword("root");
  @Container
  @ServiceConnection
  private final static KafkaContainer kafka = new KafkaContainer(
      DockerImageName.parse("confluentinc/cp-kafka:latest"));

  @DynamicPropertySource
  private static void setupProperties(DynamicPropertyRegistry registry) {
    registry.add("bootstrap.servers", kafka::getBootstrapServers);
  }

  @Test
  void contextLoads() {
    //Думаю тесты нужно делать используя TestContainers реализовать не хватило времени
  }

}
