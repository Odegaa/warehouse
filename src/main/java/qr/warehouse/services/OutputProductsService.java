package qr.warehouse.services;

import qr.warehouse.finaly.Result;
import qr.warehouse.models.OutputProducts;
import qr.warehouse.payload.OutputProductsDTO;

import java.util.List;

public interface OutputProductsService {
    List<OutputProducts> getAllOutputProducts();

    OutputProducts getOutputProductById(Long outputProductId);

    Result addOutputProduct(OutputProductsDTO outputProductsDTO);

    Result updateOutputProductById(Long outputProductId, OutputProductsDTO outputProductsDTO);

    Result deleteOutputProductById(Long outputProductId);

}
