package qr.warehouse.services;

import qr.warehouse.finaly.Result;
import qr.warehouse.models.Measurement;

import java.util.List;

public interface MeasurementService {
    Result addMeasurement(Measurement measurement);

    List<Measurement> getMeasurementList();

    Result updateMeasurement(Long measurementId, Measurement measurement);

    Result deleteMeasurement(Long measurementId);

    Measurement getMeasurementById(Long measurementId);
}
