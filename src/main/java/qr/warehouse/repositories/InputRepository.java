package qr.warehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qr.warehouse.models.Input;

@Repository
public interface InputRepository extends JpaRepository<Input, Long> {

    boolean existsInputByCode(String code);

}