package ru.factory.coffee.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.factory.coffee.model.BrigadeReport;
import ru.factory.coffee.model.CookBrigade;

public interface CookBrigadeRepository extends JpaRepository<CookBrigade, Long> {

  @Query(value = """
      SELECT c.brigade_name,
             s.country_code,
             ROUND(((s.gross_weight - c.net_weight) / s.gross_weight) * 100, 1) percent
      FROM cook_brigade c
               INNER JOIN store s ON c.store_id = s.id
      WHERE s.country_code = '?'
      ORDER BY percent
      """, nativeQuery = true)
  List<BrigadeReport> getReportByCountryCode(String code);

  @Query(value = """
      SELECT c.brigade_name,
             s.country_code,
             ROUND(((s.gross_weight - c.net_weight) / s.gross_weight) * 100, 1) percent
      FROM cook_brigade c
               INNER JOIN store s ON c.store_id = s.id
      WHERE c.brigade_name = '?'
      ORDER BY percent
      """, nativeQuery = true)
  List<BrigadeReport> getReportByBrigadeName(String name);

}
