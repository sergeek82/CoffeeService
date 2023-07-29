package ru.factory.coffee.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.factory.coffee.dto.StoreDto;
import ru.factory.coffee.mapper.StoreMapper;
import ru.factory.coffee.model.StoreReport;
import ru.factory.coffee.repository.CoffeeStoreRepository;

@Service
@RequiredArgsConstructor
public class StoreService {


  private final CoffeeStoreRepository storeRepository;
  private final StoreMapper mapper;

  @Transactional
  public List<StoreDto> getRemainsByCountry(String code) {
    List<StoreReport> byCountryCode = storeRepository.getReportByCountryCode(code);
    return mapper.toStoreDtoList(byCountryCode);
  }

  @Transactional
  public List<StoreDto> getRemainsByType(String type) {
    List<StoreReport> reportByType = storeRepository.getReportByType(type);
    return mapper.toStoreDtoList(reportByType);
  }

}
