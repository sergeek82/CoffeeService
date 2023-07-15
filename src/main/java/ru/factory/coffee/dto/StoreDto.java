package ru.factory.coffee.dto;

import lombok.Data;

@Data
public class StoreDto {

  private Integer totalWeight;
  private String countryCode;
  private String type;
}
