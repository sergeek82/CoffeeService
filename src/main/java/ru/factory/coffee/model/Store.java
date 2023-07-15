package ru.factory.coffee.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "store")
@Setter
@Getter
@NoArgsConstructor
public class Store {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
  @Column(name = "gross_weight")
  private Integer grossWeight;
  @Column(name = "robusta")
  private Byte robusta;
  @Column(name = "arabica")
  private Byte arabica;
  @Column(name = "country_code")
  private String countryCode;
  @Column(name = "type")
  private String type;

  @OneToOne(mappedBy = "store")
  private CookBrigade cookBrigade;

}
