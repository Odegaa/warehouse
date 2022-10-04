package qr.warehouse.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import qr.warehouse.finaly.Result;
import qr.warehouse.models.InputProducts;
import qr.warehouse.payload.InputProductsDTO;
import qr.warehouse.services.InputProductsService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/inputProducts")
public class InputProductsController {

    private final InputProductsService service;

    @GetMapping
    private List<InputProducts> getAllInputProducts() {
        return service.getInputProductsList();
    }

    @GetMapping("/{inputProductsId}")
    private InputProducts getInputProductById(@PathVariable Long inputProductsId) {
        return service.getInputProductById(inputProductsId);
    }

    @PostMapping
    private Result addInputProducts(@RequestBody InputProductsDTO inputProductsDTO) {
        return service.addInputProducts(inputProductsDTO);
    }

    @PutMapping("/{inputProductId}")
    private Result updateInputProduct(@PathVariable Long inputProductId,
                                      @RequestBody InputProductsDTO inputProductsDTO) {
        return service.updateInputProduct(inputProductId, inputProductsDTO);
    }

    @DeleteMapping("/{inputProductId}")
    private Result deleteInputProducts(@PathVariable Long inputProductId) {
        return service.deleteInputProducts(inputProductId);
    }

}