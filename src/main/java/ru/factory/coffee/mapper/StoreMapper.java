package ru.factory.coffee.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.factory.coffee.dto.StoreDto;
import ru.factory.coffee.dto.StoreFullDto;
import ru.factory.coffee.model.Store;
import ru.factory.coffee.model.StoreReport;

@Mapper(componentModel = "spring")
public interface StoreMapper {

  StoreDto toDto(StoreReport storeReport);
  List<StoreDto> toStoreDtoList(List<StoreReport> storeReportList);

  @Mapping(target = "cookBrigade", ignore = true)
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "robusta",resultType = Byte.class)
  @Mapping(target = "arabica",resultType = Byte.class)
  Store toEntity(StoreFullDto storeFullDto);

  @Mapping(target = "robusta",source = "robusta",resultType = Integer.class)
  @Mapping(target = "arabica",source = "arabica",resultType = Integer.class)
  StoreFullDto toFullDto(Store store);
}
