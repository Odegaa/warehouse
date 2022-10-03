package qr.warehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qr.warehouse.models.OutputProducts;

@Repository
public interface OutputProductsRepository extends JpaRepository<OutputProducts, Long> {


}