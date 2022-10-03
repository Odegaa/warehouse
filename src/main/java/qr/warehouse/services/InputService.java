package qr.warehouse.services;

import qr.warehouse.finaly.Result;
import qr.warehouse.models.Input;
import qr.warehouse.payload.InputDTO;

import java.util.List;

public interface InputService {


    Result addInput(InputDTO inputDTO);

    List<Input> getInputs();

    Input getInputById(Long inputId);

    Result updateProduct(Long inputId, InputDTO inputDTO);

    Result deleteInput(Long inputId);
}