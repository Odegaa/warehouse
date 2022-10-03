package qr.warehouse.services;

import qr.warehouse.finaly.Result;
import qr.warehouse.models.Output;
import qr.warehouse.payload.OutputDTO;

import java.util.List;

public interface OutputService {
    Result addOutput(OutputDTO outputDTO);

    List<Output> getAllOutputs();

    Output getOutput(Long outputId);

}
