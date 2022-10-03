package qr.warehouse.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import qr.warehouse.finaly.Result;
import qr.warehouse.models.Supplier;
import qr.warehouse.services.SupplierService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/supplier")
public class SupplierController {

    private final SupplierService service;

    @GetMapping
    private List<Supplier> getSuppliers() {
        return service.getAllSuppliers();
    }

    @GetMapping("/{supplierId}")
    private Supplier getSupplierById(@PathVariable Long supplierId) {
        return service.getSupplierById(supplierId);
    }

    @PostMapping
    private Result addSupplier(@RequestBody Supplier supplier) {
        return service.addSupplier(supplier);
    }

    @PutMapping("/{supplierId}")
    private Result updateSupplier(@PathVariable Long supplierId,
                                  @RequestBody Supplier supplier) {
        return service.updateSupplier(supplierId, supplier);
    }

    @DeleteMapping("/{supplierId}")
    private Result deleteSupplier(@PathVariable Long supplierId) {
        return service.deleteSupplier(supplierId);
    }

}
