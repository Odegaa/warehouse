package qr.warehouse.services.serviceImplements;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import qr.warehouse.finaly.Result;
import qr.warehouse.models.Warehouse;
import qr.warehouse.repositories.WarehouseRepository;
import qr.warehouse.services.WarehouseService;

import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WarehouseServiceImpl implements WarehouseService {

    private final WarehouseRepository repository;

    @Override
    public List<Warehouse> getAllWarehouses() {
        return repository.findAll();
    }

    @Override
    public Result addNewWarehouse(Warehouse warehouse) {
        try {
            boolean checkCompanyName =
                    repository.existsWarehouseByCompany_name(warehouse.getCompany_name());
            if (checkCompanyName) {
                return new Result("This company already exist", false);
            } else {
                Warehouse newWarehouse = new Warehouse();
                newWarehouse.setCompany_name(warehouse.getCompany_name());
                newWarehouse.setStatus(true);

                repository.save(newWarehouse);
                return new Result("Successfully added", true);
            }
        } catch (Exception e) {
            return new Result("An error occurred", false);
        }

    }

    @Override
    public Result updateWarehouse(Long warehouseId, Warehouse warehouse) {
        Optional<Warehouse> optionalWarehouse = repository.findById(warehouseId);
        if (optionalWarehouse.isPresent()) {
            Warehouse updatingWarehouse = optionalWarehouse.get();
            updatingWarehouse.setCompany_name(warehouse.getCompany_name());
            updatingWarehouse.setStatus(true);

            repository.save(updatingWarehouse);
            return new Result("Successfully updated!", true);
        } else
            return new Result("Warehouse is not found or exception", false);
    }

    @Override
    public Result removeWarehouse(Long warehouseId) {
        Optional<Warehouse> optionalWarehouse = repository.findById(warehouseId);
        if (optionalWarehouse.isPresent()) {
            repository.deleteById(warehouseId);
            return new Result("Successfully deleted!", true);
        } else
            return new Result("warehouse not found or Exception!", false);
    }

    @Override
    public Warehouse getWarehouseById(Long warehouseId) {
        return repository.findById(warehouseId).orElse(null);
    }

}