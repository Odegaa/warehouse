package qr.warehouse.services;

import qr.warehouse.finaly.Result;
import qr.warehouse.models.Warehouse;

import java.util.List;

public interface WarehouseService {

    List<Warehouse> getAllWarehouses();

    Result addNewWarehouse(Warehouse warehouse);

    Result updateWarehouse(Long warehouseId, Warehouse warehouse);

    Result removeWarehouse(Long warehouseId);

    Warehouse getWarehouseById(Long warehouseId);

}
