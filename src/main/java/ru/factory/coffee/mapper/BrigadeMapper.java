package ru.factory.coffee.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.factory.coffee.dto.BrigadeDto;
import ru.factory.coffee.grpc.RoastServiceOuterClass.RoastRequest;
import ru.factory.coffee.model.BrigadeReport;
import ru.factory.coffee.model.CookBrigade;

@Mapper(componentModel = "spring")
public interface BrigadeMapper {

  BrigadeDto toDto(BrigadeReport brigadeReport);

  List<BrigadeDto> toBrigadeDtoList(List<BrigadeReport> brigadeReportList);

  @Mapping(target = "store", ignore = true)
  @Mapping(target = "id",ignore = true)
  @Mapping(target = "name",source = "brigadeName")
  CookBrigade toEntity(RoastRequest request);

}
