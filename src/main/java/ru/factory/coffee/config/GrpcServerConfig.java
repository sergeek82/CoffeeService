package ru.factory.coffee.config;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.factory.coffee.service.RoastService;

@Configuration
@RequiredArgsConstructor
public class GrpcServerConfig {

  private final RoastService roastService;

  @Bean
  public Server server() throws IOException, InterruptedException {
    Server server = ServerBuilder.forPort(8080).addService(roastService).build();
    server.start();
    server.awaitTermination();
    return server;
  }
}
