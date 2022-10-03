package qr.warehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qr.warehouse.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    boolean existsClientByPhoneNumber(String phoneNumber);

}