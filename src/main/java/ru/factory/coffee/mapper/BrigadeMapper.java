package ru.factory.coffee.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import ru.factory.coffee.dto.BrigadeDto;
import ru.factory.coffee.model.BrigadeReport;

@Mapper(componentModel = "spring")
public interface BrigadeMapper {

  BrigadeDto toDto(BrigadeReport brigadeReport);

  List<BrigadeDto> toStoreDtoList(List<BrigadeReport> brigadeReportList);

}
