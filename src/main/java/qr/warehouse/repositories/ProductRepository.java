package qr.warehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qr.warehouse.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {



}