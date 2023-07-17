package ru.factory.coffee.controller;

import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.factory.coffee.api.StoreApi;
import ru.factory.coffee.dto.StoreDto;
import ru.factory.coffee.service.StoreService;

@RestController
@RequiredArgsConstructor
public class StoreController implements StoreApi {

  private final StoreService service;

  @Override
  public List<StoreDto> getRemainsByCountry(@NotNull String code) {
    return service.getRemainsByCountry(code);
//    return StoreApi.super.getRemainsByCountry(code);
  }

  @Override
  public List<StoreDto> getRemainsByType(@NotNull String type) {
    return service.getRemainsByType(type);
//    return StoreApi.super.getRemainsByType(type);
  }
}
