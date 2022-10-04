package qr.warehouse.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import qr.warehouse.finaly.Result;
import qr.warehouse.models.OutputProducts;
import qr.warehouse.payload.OutputProductsDTO;
import qr.warehouse.services.OutputProductsService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/outputProducts")
public class OutputProductsController {

    private final OutputProductsService service;

    @GetMapping
    private List<OutputProducts> getOutputProductsList() {
        return service.getAllOutputProducts();
    }

    @GetMapping("/{outputProductId}")
    private OutputProducts getOutputProductById(@PathVariable Long outputProductId) {
        return service.getOutputProductById(outputProductId);
    }

    @PostMapping
    private Result addOutputProduct(@RequestBody OutputProductsDTO outputProductsDTO) {
        return service.addOutputProduct(outputProductsDTO);
    }

    @PutMapping("/{outputProductId}")
    private Result updateOutputProductById(@PathVariable Long outputProductId,
                                           @RequestBody OutputProductsDTO outputProductsDTO) {
        return service.updateOutputProductById(outputProductId, outputProductsDTO);
    }

    @DeleteMapping("/{outputProductId}")
    private Result deleteOutputProductById(@PathVariable Long outputProductId) {
        return service.deleteOutputProductById(outputProductId);
    }

}