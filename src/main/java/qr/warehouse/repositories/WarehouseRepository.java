package qr.warehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import qr.warehouse.models.Warehouse;

import java.util.List;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

    @Query("select (count(w) > 0) from warehouse w where w.company_name = ?1")
    boolean existsWarehouseByCompany_name(String Company_name);


}