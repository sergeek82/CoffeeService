package ru.factory.coffee.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.factory.coffee.dto.BrigadeDto;
import ru.factory.coffee.mapper.BrigadeMapper;
import ru.factory.coffee.model.BrigadeReport;
import ru.factory.coffee.repository.CookBrigadeRepository;

@Service
@RequiredArgsConstructor
public class BrigadeService {

  private final CookBrigadeRepository brigadeRepository;
  private final BrigadeMapper mapper;
  @Transactional
  public List<BrigadeDto> getLossPercentByCountryCode(String code) {
    List<BrigadeReport> reportByCountryCode = brigadeRepository.getReportByCountryCode(code);
    return mapper.toBrigadeDtoList(reportByCountryCode);
  }
  @Transactional
  public List<BrigadeDto> getLossPercentByBrigadeName(String name) {
    List<BrigadeReport> reportByBrigadeName = brigadeRepository.getReportByBrigadeName(name);
    return mapper.toBrigadeDtoList(reportByBrigadeName);
  }
}
