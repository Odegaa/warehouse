package qr.warehouse.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import qr.warehouse.finaly.Result;
import qr.warehouse.models.Measurement;
import qr.warehouse.services.MeasurementService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/measurement")
public class MeasurementController {

    private final MeasurementService service;

    @PostMapping
    private Result addMeasurement(@RequestBody Measurement measurement) {
        return service.addMeasurement(measurement);
    }

    @GetMapping
    private List<Measurement> getAllMeasurements() {
        return service.getMeasurementList();
    }

    @GetMapping("/{measurementId}")
    private Measurement getMeasurementById(@PathVariable Long measurementId) {
        return service.getMeasurementById(measurementId);
    }

    @PutMapping("/{measurementId}")
    private Result updateMeasurement(@PathVariable Long measurementId,
                                     @RequestBody Measurement measurement) {
        return service.updateMeasurement(measurementId, measurement);
    }

    @DeleteMapping("/{measurementId}")
    private Result deleteMeasurement(@PathVariable Long measurementId) {
        return service.deleteMeasurement(measurementId);
    }

}