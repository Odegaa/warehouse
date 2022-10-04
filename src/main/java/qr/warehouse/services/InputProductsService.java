package qr.warehouse.services;

import qr.warehouse.finaly.Result;
import qr.warehouse.models.InputProducts;
import qr.warehouse.payload.InputProductsDTO;

import java.util.List;

public interface InputProductsService {

    List<InputProducts> getInputProductsList();


    InputProducts getInputProductById(Long inputProductsId);

    Result addInputProducts(InputProductsDTO inputProductsDTO);

    Result updateInputProduct(Long inputProductId, InputProductsDTO inputProductsDTO);

    Result deleteInputProducts(Long inputProductId);
}