package qr.warehouse.services.serviceImplements;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import qr.warehouse.finaly.Result;
import qr.warehouse.models.Client;
import qr.warehouse.models.Currency;
import qr.warehouse.models.Output;
import qr.warehouse.models.Warehouse;
import qr.warehouse.payload.OutputDTO;
import qr.warehouse.repositories.ClientRepository;
import qr.warehouse.repositories.CurrencyRepository;
import qr.warehouse.repositories.OutputRepository;
import qr.warehouse.repositories.WarehouseRepository;
import qr.warehouse.services.OutputService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OutputServiceImpl implements OutputService {

    private final OutputRepository repository;
    private final WarehouseRepository warehouseRepository;
    private final CurrencyRepository currencyRepository;
    private final ClientRepository clientRepository;

    @Override
    public Result addOutput(OutputDTO outputDTO) {
        Output output = new Output();
        return setData(output, outputDTO);
    }

    @Override
    public List<Output> getAllOutputs() {
        return repository.findAll();
    }

    @Override
    public Output getOutput(Long outputId) {
        return repository.findById(outputId).orElse(null);
    }

    @Override
    public Result updateOutput(Long outputId, OutputDTO outputDTO) {
        Optional<Output> outputOptional = repository.findById(outputId);
        if(outputOptional.isPresent()) {
            Output output = outputOptional.get();
            setData(output, outputDTO);
        }
        return new Result("Output not found!", false);
    }

    @Override
    public Result deleteOutput(Long outputId) {
        Optional<Output> outputOptional = repository.findById(outputId);
        if(outputOptional.isPresent()) {
            repository.deleteById(outputId);
            return new Result("Output deleted!", true);
        }
        return new Result("Output not found!", false);
    }


    private Result setData(Output output, OutputDTO outputDTO) {

        Optional<Warehouse> warehouseOptional = warehouseRepository.findById(outputDTO.getWarehouseId());
        warehouseOptional.ifPresent(output::setWarehouse_id);

        Optional<Currency> currencyOptional = currencyRepository.findById(outputDTO.getCurrencyId());
        currencyOptional.ifPresent(output::setCurrency_id);

        Optional<Client> clientOptional = clientRepository.findById(outputDTO.getClientId());
        clientOptional.ifPresent(output::setClient_id);

        output.setDate(outputDTO.getDate());
        output.setFactureNumber(outputDTO.getFactureNumber());
        output.setGenerationCode(outputDTO.getGenerationCode());
        repository.save(output);
        return new Result("Successfully saved!", true);
    }

}