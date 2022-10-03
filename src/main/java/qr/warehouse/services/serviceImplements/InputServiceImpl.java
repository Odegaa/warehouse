package qr.warehouse.services.serviceImplements;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import qr.warehouse.finaly.Result;
import qr.warehouse.models.Currency;
import qr.warehouse.models.Input;
import qr.warehouse.models.Supplier;
import qr.warehouse.models.Warehouse;
import qr.warehouse.payload.InputDTO;
import qr.warehouse.repositories.CurrencyRepository;
import qr.warehouse.repositories.InputRepository;
import qr.warehouse.repositories.SupplierRepository;
import qr.warehouse.repositories.WarehouseRepository;
import qr.warehouse.services.InputService;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InputServiceImpl implements InputService {

    private final InputRepository inputRepository;
    private final WarehouseRepository warehouseRepository;
    private final SupplierRepository supplierRepository;
    private final CurrencyRepository currencyRepository;

    @Override
    public Result addInput(InputDTO inputDTO) {
        boolean byCode = inputRepository.existsInputByCode(inputDTO.getCode());
        if (byCode) {
            return new Result("Code already exist!", false);
        }
        Input newInput = new Input();
        newInput.setDateTimeFormat(new Date());
        Optional<Warehouse> warehouseOptional = warehouseRepository.findById(inputDTO.getWarehouseId());
        Optional<Supplier> supplierOptional = supplierRepository.findById(inputDTO.getSupplierId());
        Optional<Currency> currencyOptional = currencyRepository.findById(inputDTO.getCurrencyId());
        warehouseOptional.ifPresent(newInput::setWarehouse_id);
        supplierOptional.ifPresent(newInput::setSupplier_id);
        currencyOptional.ifPresent(newInput::setCurrency_id);
        newInput.setFacture_number(inputDTO.getFacture_number());
        newInput.setCode(UUID.randomUUID().toString());
        inputRepository.save(newInput);
        return new Result("Successfully saved!", true);
    }

    @Override
    public List<Input> getInputs() {
        return inputRepository.findAll();
    }

    @Override
    public Input getInputById(Long inputId) {
        return inputRepository.findById(inputId).orElse(null);
    }

    @Override
    public Result updateProduct(Long inputId, InputDTO inputDTO) {
        Optional<Input> inputOptional = inputRepository.findById(inputId);
        if (inputOptional.isPresent()) {
            Input updatingInput = inputOptional.get();
            updatingInput.setDateTimeFormat(inputDTO.getDateTimeFormat());

            Optional<Warehouse> warehouseOptional = warehouseRepository.findById(inputDTO.getWarehouseId());
            warehouseOptional.ifPresent(updatingInput::setWarehouse_id);

            Optional<Supplier> supplierOptional = supplierRepository.findById(inputDTO.getSupplierId());
            supplierOptional.ifPresent(updatingInput::setSupplier_id);

            Optional<Currency> currencyOptional = currencyRepository.findById(inputDTO.getCurrencyId());
            currencyOptional.ifPresent(updatingInput::setCurrency_id);

            updatingInput.setFacture_number(inputDTO.getFacture_number());
            updatingInput.setCode(inputDTO.getCode());

            inputRepository.save(updatingInput);
            return new Result("Successfully updated!", true);
        }
        return new Result("Inputs not found or EXCEPTION!", false);
    }

    @Override
    public Result deleteInput(Long inputId) {
        Optional<Input> inputOptional = inputRepository.findById(inputId);
        if(inputOptional.isPresent()) {
            inputRepository.deleteById(inputId);
            return new Result("Input deleted!", true);
        }
        return new Result("Input not found!", false);
    }

}