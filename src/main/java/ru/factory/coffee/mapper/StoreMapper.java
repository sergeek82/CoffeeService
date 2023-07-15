package ru.factory.coffee.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import ru.factory.coffee.dto.StoreDto;
import ru.factory.coffee.model.StoreReport;

@Mapper(componentModel = "spring")
public interface StoreMapper {

  StoreDto toDto(StoreReport storeReport);

  List<StoreDto> toStoreDtoList(List<StoreReport> storeReportList);

}
