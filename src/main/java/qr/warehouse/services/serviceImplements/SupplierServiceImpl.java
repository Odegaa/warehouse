package qr.warehouse.services.serviceImplements;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import qr.warehouse.finaly.Result;
import qr.warehouse.models.Supplier;
import qr.warehouse.repositories.SupplierRepository;
import qr.warehouse.services.SupplierService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;


    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    @Override
    public Result addSupplier(Supplier supplier) {
        try {
            boolean supplierByPhoneNumber =
                    supplierRepository.existsSupplierByPhoneNumber(supplier.getPhoneNumber());
            if (supplierByPhoneNumber) {
                return new Result("This phone number already exist", false);
            } else {
                Supplier newSupplier = new Supplier();
                newSupplier.setSurname(supplier.getSurname());
                newSupplier.setName(supplier.getName());
                newSupplier.setPhoneNumber(supplier.getPhoneNumber());
                newSupplier.setStatus(true);

                supplierRepository.save(newSupplier);
                return new Result("Successfully saved!", true);
            }
        } catch (Exception e) {
            return new Result("An error occurred", false);
        }
    }

    @Override
    public Result updateSupplier(Long supplierId, Supplier supplier) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(supplierId);
        if (optionalSupplier.isPresent()) {
            Supplier updatingSupplier = optionalSupplier.get();
            updatingSupplier.setSurname(supplier.getSurname());
            updatingSupplier.setName(supplier.getName());
            updatingSupplier.setPhoneNumber(supplier.getPhoneNumber());
            updatingSupplier.setStatus(true);

            supplierRepository.save(updatingSupplier);
            return new Result("Successfully updated!", true);
        }
        return new Result("supplier not found or Exception!", false);
    }

    @Override
    public Result deleteSupplier(Long supplierId) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(supplierId);
        if (optionalSupplier.isPresent()) {
            supplierRepository.deleteById(supplierId);
            return new Result("Supplier deleted!", true);
        }
        return new Result("Supplier not found or EXCEPTION!", false);
    }

    @Override
    public Supplier getSupplierById(Long supplierId) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(supplierId);
        return optionalSupplier.orElse(null);
    }
}