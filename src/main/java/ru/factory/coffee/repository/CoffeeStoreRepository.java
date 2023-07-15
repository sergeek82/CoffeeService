package ru.factory.coffee.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.factory.coffee.model.Store;
import ru.factory.coffee.model.StoreReport;

public interface CoffeeStoreRepository extends JpaRepository<Store, Long> {

  List<Store> findAllByCountryCode(String code);

  List<Store> findAllByType(String type);

  @Query(value = """
            SELECT type, SUM(gross_weight) AS totalWeight
            FROM store
            WHERE type = '?'
            GROUP BY type
            ORDER BY totalWeight
      """, nativeQuery = true)
  List<StoreReport> getReportByType(String type);

  @Query(value = """
            SELECT type, SUM(gross_weight) AS totalWeight
            FROM store
            WHERE country_code = '?'
            GROUP BY type
            ORDER BY totalWeight
      """, nativeQuery = true)
  List<StoreReport> getReportByCountryCode(String code);
}
