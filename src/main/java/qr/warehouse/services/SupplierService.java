package qr.warehouse.services;

import qr.warehouse.finaly.Result;
import qr.warehouse.models.Supplier;

import java.util.List;

public interface SupplierService {
    List<Supplier> getAllSuppliers();

    Result addSupplier(Supplier supplier);

    Result updateSupplier(Long supplierId, Supplier supplier);

    Result deleteSupplier(Long supplierId);

    Supplier getSupplierById(Long supplierId);
}
