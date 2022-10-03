package qr.warehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qr.warehouse.models.Measurement;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Long> {

    boolean existsMeasurementByMeasurementName(String measurementName);

}