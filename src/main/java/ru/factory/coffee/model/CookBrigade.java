package ru.factory.coffee.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cook_brigade")
@Setter
@Getter
@NoArgsConstructor
public class CookBrigade {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
  @Column(name = "net_weight")
  private Integer netWeight;
  @Column(name = "brigade_name")
  private String name;

  @OneToOne
  @JoinColumn(name = "store_id", referencedColumnName = "id")
  private Store store;

}
