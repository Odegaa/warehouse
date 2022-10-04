package qr.warehouse.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import qr.warehouse.finaly.Result;
import qr.warehouse.models.Output;
import qr.warehouse.payload.OutputDTO;
import qr.warehouse.services.OutputService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class OutputController {

    private final OutputService service;

    @PostMapping
    private Result addOutputs(@RequestBody OutputDTO outputDTO) {
        return service.addOutput(outputDTO);
    }

    @GetMapping
    private List<Output> getAllOutputs() {
        return service.getAllOutputs();
    }

    @GetMapping("/{outputId}")
    private Output getOutput(@PathVariable Long outputId) {
        return service.getOutput(outputId);
    }

    @PutMapping("/{outputId}")
    private Result updateOutput(@PathVariable Long outputId,
                                @RequestBody OutputDTO outputDTO) {
        return service.updateOutput(outputId,outputDTO);
    }

    @DeleteMapping("/{outputId}")
    private Result deleteOutput(@PathVariable Long outputId) {
        return service.deleteOutput(outputId);
    }

}