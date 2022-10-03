package qr.warehouse.services;

import qr.warehouse.finaly.Result;
import qr.warehouse.models.Product;
import qr.warehouse.payload.ProductDTO;

import java.util.List;

public interface ProductService {
    List<Product> getProductList();

    Product getProductById(Long productId);

    Result addProduct(ProductDTO productDTO);

    Result updateProduct(Long productId, ProductDTO productDTO);

    Result deleteProduct(Long productId);
}
