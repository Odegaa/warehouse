package qr.warehouse.services.serviceImplements;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import qr.warehouse.finaly.Result;
import qr.warehouse.models.Output;
import qr.warehouse.models.OutputProducts;
import qr.warehouse.models.Product;
import qr.warehouse.payload.OutputProductsDTO;
import qr.warehouse.repositories.OutputProductsRepository;
import qr.warehouse.repositories.OutputRepository;
import qr.warehouse.repositories.ProductRepository;
import qr.warehouse.services.OutputProductsService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OutputProductsServiceImpl implements OutputProductsService {

    private final OutputProductsRepository repository;
    private final ProductRepository productRepository;
    private final OutputRepository outputRepository;

    @Override
    public List<OutputProducts> getAllOutputProducts() {
        return repository.findAll();
    }

    @Override
    public OutputProducts getOutputProductById(Long outputProductId) {
        return repository.findById(outputProductId).orElse(null);
    }

    @Override
    public Result addOutputProduct(OutputProductsDTO outputProductsDTO) {
        OutputProducts outputProducts = new OutputProducts();
        return setData(outputProductsDTO, outputProducts);
    }

    @Override
    public Result updateOutputProductById(Long outputProductId, OutputProductsDTO outputProductsDTO) {
        Optional<OutputProducts> productsOptional = repository.findById(outputProductId);
        if (productsOptional.isPresent()) {
            OutputProducts updateOutputProduct = productsOptional.get();
            return setData(outputProductsDTO, updateOutputProduct);
        }
        return new Result("Output product not found!", false);
    }

    @Override
    public Result deleteOutputProductById(Long outputProductId) {
        Optional<OutputProducts> productsOptional = repository.findById(outputProductId);
        if (productsOptional.isPresent()) {
            repository.deleteById(outputProductId);
            return new Result("output product deleted!", true);
        }
        return new Result("Output product not found!", false);
    }

    private Result setData(OutputProductsDTO outputProductsDTO, OutputProducts outputProducts) {
        Optional<Product> productOptional = productRepository.findById(outputProductsDTO.getProductId());
        productOptional.ifPresent(outputProducts::setProduct_id);

        Optional<Output> outputOptional = outputRepository.findById(outputProductsDTO.getOutputId());
        outputOptional.ifPresent(outputProducts::setOutput_id);

        outputProducts.setAmount(outputProductsDTO.getAmount());
        outputProducts.setPrice(outputProductsDTO.getPrice());

        repository.save(outputProducts);
        return new Result("Successfully updated!", true);
    }

}