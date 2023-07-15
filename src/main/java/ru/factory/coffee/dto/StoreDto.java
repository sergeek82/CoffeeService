package ru.factory.coffee.dto;

import java.util.UUID;
import lombok.Data;

@Data
public class PurchaseDto {
  private UUID id;
  private Integer grossWeight;
  private Byte robusta;
  private Byte arabica;
  private String countryCode;
  private String type;
}
