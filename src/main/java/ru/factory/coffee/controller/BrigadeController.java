package ru.factory.coffee.controller;

import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.factory.coffee.api.BrigadeApi;
import ru.factory.coffee.dto.BrigadeDto;
import ru.factory.coffee.service.BrigadeService;

@RestController
@RequiredArgsConstructor
public class BrigadeController implements BrigadeApi {

  private final BrigadeService service;

  @Override
  public List<BrigadeDto> getLossPercentByCountry(@NotNull String code) {
    return service.getLossPercentByCountryCode(code);
//    return BrigadeApi.super.getLossPercentByCountry(code);
  }

  @Override
  public List<BrigadeDto> getLossPercentByName(@NotNull String name) {
    return service.getLossPercentByBrigadeName(name);
//    return BrigadeApi.super.getLossPercentByName(name);
  }
}
