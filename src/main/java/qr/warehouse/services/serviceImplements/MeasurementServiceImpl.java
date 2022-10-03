package qr.warehouse.services.serviceImplements;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import qr.warehouse.finaly.Result;
import qr.warehouse.models.Measurement;
import qr.warehouse.repositories.MeasurementRepository;
import qr.warehouse.services.MeasurementService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MeasurementServiceImpl implements MeasurementService {

    private final MeasurementRepository repository;

    @Override
    public Result addMeasurement(Measurement measurement) {
        boolean measurementName = repository.existsMeasurementByMeasurementName(measurement.getMeasurementName());
        if (measurementName) {
            return new Result("This measurement already exist", false);
        } else {
            Measurement newMeasurement = new Measurement();
            newMeasurement.setMeasurementName(measurement.getMeasurementName());
            newMeasurement.setStatus(true);
            repository.save(newMeasurement);
            return new Result("Successfully saved!", true);
        }
    }

    @Override
    public List<Measurement> getMeasurementList() {
        return repository.findAll();
    }

    @Override
    public Result updateMeasurement(Long measurementId, Measurement measurement) {
        Optional<Measurement> optionalMeasurement = repository.findById(measurementId);
        if (optionalMeasurement.isPresent()) {
            Measurement updatingMeasurement = optionalMeasurement.get();
            updatingMeasurement.setMeasurementName(measurement.getMeasurementName());
            updatingMeasurement.setStatus(true);

            repository.save(updatingMeasurement);
            return new Result("Successfully updated!", true);
        }
        return new Result("Measurement is not found or Exception!", false);
    }

    @Override
    public Result deleteMeasurement(Long measurementId) {
        Optional<Measurement> optionalMeasurement = repository.findById(measurementId);
        if (optionalMeasurement.isPresent()) {
            repository.deleteById(measurementId);
            return new Result("Measurement deleted!", true);
        }
        return new Result("Measurement is not found or Exception!", false);
    }

    @Override
    public Measurement getMeasurementById(Long measurementId) {
        Optional<Measurement> measurementOptional = repository.findById(measurementId);
        return measurementOptional.orElse(null);
    }
}