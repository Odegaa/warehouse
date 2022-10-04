package qr.warehouse.services.serviceImplements;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import qr.warehouse.finaly.Result;
import qr.warehouse.models.Attachment;
import qr.warehouse.models.Category;
import qr.warehouse.models.Measurement;
import qr.warehouse.models.Product;
import qr.warehouse.payload.ProductDTO;
import qr.warehouse.repositories.AttachmentRepository;
import qr.warehouse.repositories.CategoryRepository;
import qr.warehouse.repositories.MeasurementRepository;
import qr.warehouse.repositories.ProductRepository;
import qr.warehouse.services.ProductService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final AttachmentRepository attachmentRepository;
    private final MeasurementRepository measurementRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public List<Product> getProductList() {
        return repository.findAll();
    }

    @Override
    public Product getProductById(Long productId) {
        return repository.findById(productId).orElse(null);
    }

    @Override
    public Result addProduct(ProductDTO productDTO) {
        Product newProduct = new Product();
        newProduct.setProductName(productDTO.getProductName());
        return setData(newProduct, productDTO);
    }

    @Override
    public Result updateProduct(Long productId, ProductDTO productDTO) {
        Optional<Product> productOptional = repository.findById(productId);
        if (productOptional.isPresent()) {
            Product updatingProduct = productOptional.get();
            updatingProduct.setProductName(productDTO.getProductName());
            return setData(updatingProduct, productDTO);
        }
        return new Result("Product not found or EXCEPTION!", false);
    }

    @Override
    public Result deleteProduct(Long productId) {
        Optional<Product> productOptional = repository.findById(productId);
        if (productOptional.isPresent()) {
            repository.deleteById(productId);
            return new Result("Product deleted!", true);
        }
        return new Result("Product not found or EXCEPTION!", false);
    }

    private Result setData(Product product, ProductDTO productDTO) {
        Optional<Category> categoryOptional = categoryRepository.findById(productDTO.getCategoryId());
        if (categoryOptional.isEmpty())
            return new Result("Category not found!", false);

        Optional<Attachment> attachmentOptional = attachmentRepository.findById(productDTO.getAttachmentId());
        if (attachmentOptional.isEmpty())
            return new Result("Attachment not found!", false);

        Optional<Measurement> measurementOptional = measurementRepository.findById(productDTO.getMeasurementId());
        if (measurementOptional.isEmpty())
            return new Result("Measurement not found!", false);

        product.setCategory_id(categoryOptional.get());
        product.setAttachment_id(attachmentOptional.get());
        product.setMeasurement_id(measurementOptional.get());
        repository.save(product);

        return new Result("Successfully saved!", true);
    }
}