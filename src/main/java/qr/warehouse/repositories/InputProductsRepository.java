package qr.warehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qr.warehouse.models.InputProducts;

@Repository
public interface InputProductsRepository extends JpaRepository<InputProducts, Long> {



}