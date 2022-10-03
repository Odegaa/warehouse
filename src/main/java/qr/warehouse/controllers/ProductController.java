package qr.warehouse.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import qr.warehouse.finaly.Result;
import qr.warehouse.models.Product;
import qr.warehouse.payload.ProductDTO;
import qr.warehouse.services.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService service;

    @GetMapping
    private List<Product> getAllProducts() {
        return service.getProductList();
    }

    @GetMapping("/{productId}")
    private Product getProductById(@PathVariable Long productId) {
        return service.getProductById(productId);
    }

    @PostMapping
    private Result addProduct(@RequestBody ProductDTO productDTO) {
        return service.addProduct(productDTO);
    }

    @PutMapping("{productId}")
    private Result updateProduct(@PathVariable Long productId,
                                 @RequestBody ProductDTO productDTO) {
        return service.updateProduct(productId, productDTO);
    }

    @DeleteMapping("{productId}")
    private Result deleteProduct(@PathVariable Long productId) {
        return service.deleteProduct(productId);
    }
}