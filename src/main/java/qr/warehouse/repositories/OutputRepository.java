package qr.warehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qr.warehouse.models.Output;

@Repository
public interface OutputRepository extends JpaRepository<Output, Long> {



}
