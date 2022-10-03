package qr.warehouse.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import qr.warehouse.finaly.Result;
import qr.warehouse.models.Warehouse;
import qr.warehouse.services.WarehouseService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/warehouse")
public class WarehouseController {

    private final WarehouseService service;

    @GetMapping
    private List<Warehouse> getWarehouses() {
        return service.getAllWarehouses();
    }

    @GetMapping("/{warehouseId}")
    private Warehouse getWarehouseById(@PathVariable Long warehouseId) {
        return service.getWarehouseById(warehouseId);
    }

    @PostMapping
    private Result addNewWarehouse(@RequestBody Warehouse warehouse) {
        return service.addNewWarehouse(warehouse);
    }

    @PutMapping("/{warehouseId}")
    private Result updateWarehouse(@PathVariable Long warehouseId,
                                   @RequestBody Warehouse warehouse) {
        return service.updateWarehouse(warehouseId, warehouse);
    }

    @DeleteMapping("{warehouseId}")
    private Result deleteWarehouse(@PathVariable Long warehouseId) {
        return service.removeWarehouse(warehouseId);
    }

}