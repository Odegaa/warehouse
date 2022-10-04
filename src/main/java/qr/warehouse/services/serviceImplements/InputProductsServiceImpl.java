package qr.warehouse.services.serviceImplements;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import qr.warehouse.finaly.Result;
import qr.warehouse.models.Input;
import qr.warehouse.models.InputProducts;
import qr.warehouse.models.Product;
import qr.warehouse.payload.InputProductsDTO;
import qr.warehouse.repositories.InputProductsRepository;
import qr.warehouse.repositories.InputRepository;
import qr.warehouse.repositories.ProductRepository;
import qr.warehouse.services.InputProductsService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InputProductsServiceImpl implements InputProductsService {

    private final InputProductsRepository repository;
    private final ProductRepository productRepository;
    private final InputRepository inputRepository;

    @Override
    public List<InputProducts> getInputProductsList() {
        return repository.findAll();
    }

    @Override
    public InputProducts getInputProductById(Long inputProductsId) {
        return repository.findById(inputProductsId).orElse(null);
    }

    @Override
    public Result addInputProducts(InputProductsDTO inputProductsDTO) {
        InputProducts newInputProduct = new InputProducts();

        Optional<Input> inputOptional = inputRepository.findById(inputProductsDTO.getInputId());
        inputOptional.ifPresent(newInputProduct::setInput_id);

        Optional<Product> productOptional = productRepository.findById(inputProductsDTO.getProductId());
        productOptional.ifPresent(newInputProduct::setProduct);

        newInputProduct.setPrice(inputProductsDTO.getPrice());
        newInputProduct.setAmount(inputProductsDTO.getAmount());

        repository.save(newInputProduct);
        return new Result("Successfully saved!", true);
    }

    @Override
    public Result updateInputProduct(Long inputProductId, InputProductsDTO inputProductsDTO) {
        Optional<InputProducts> optional = repository.findById(inputProductId);
        if (optional.isEmpty()) {
            return new Result("Input products not found!", false);
        }
        InputProducts updatingInputProducts = optional.get();
        updatingInputProducts.setAmount(inputProductsDTO.getAmount());
        updatingInputProducts.setPrice(inputProductsDTO.getPrice());

        Optional<Input> optionalInput = inputRepository.findById(inputProductsDTO.getInputId());
        optionalInput.ifPresent(updatingInputProducts::setInput_id);

        Optional<Product> productOptional = productRepository.findById(inputProductsDTO.getProductId());
        productOptional.ifPresent(updatingInputProducts::setProduct);

        repository.save(updatingInputProducts);
        return new Result("Input products updated", true);
    }

    @Override
    public Result deleteInputProducts(Long inputProductId) {
        Optional<InputProducts> productsOptional = repository.findById(inputProductId);
        if(productsOptional.isPresent()) {
            repository.deleteById(inputProductId);
            return new Result("Input product deleted!", true);
        }
        return new Result("Input product not found!", false);
    }

}