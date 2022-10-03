package qr.warehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qr.warehouse.models.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    boolean existsSupplierByPhoneNumber(String phoneNumber);
}