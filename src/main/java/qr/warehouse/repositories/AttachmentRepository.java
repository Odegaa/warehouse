package qr.warehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qr.warehouse.models.Attachment;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Long> {

    boolean existsByGenerationName(String generationName);

}