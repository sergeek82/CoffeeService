package ru.factory.coffee.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "coffee_store")
@Setter
@Getter
@NoArgsConstructor
public class CoffeeStore {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private UUID id;
  private Integer grossWeight;
  private Integer netWeight;
  private Byte robusta;
  private Byte arabica;
  private String countryCode;
  private String type;
  private String teamId;
  private Boolean prepared;

}
