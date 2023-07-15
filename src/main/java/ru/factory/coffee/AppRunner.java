package ru.factory.coffee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "ru.factory.coffee")
public class AppRunner {

  public static void main(String[] args) {
    SpringApplication.run(AppRunner.class, args);
  }

}
