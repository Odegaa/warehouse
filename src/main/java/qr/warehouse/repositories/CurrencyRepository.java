package qr.warehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qr.warehouse.models.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {

    boolean existsByCurrencyName(String currencyName);

}
