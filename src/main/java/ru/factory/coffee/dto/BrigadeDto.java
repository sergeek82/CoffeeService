package ru.factory.coffee.dto;

import java.util.UUID;
import lombok.Data;

@Data
public class TeamDto {

  private UUID teamId;
  private Integer grossWeight;
  private Integer netWeight;
  private Boolean prepared;
}
