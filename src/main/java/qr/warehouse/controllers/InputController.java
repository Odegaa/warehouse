package qr.warehouse.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import qr.warehouse.finaly.Result;
import qr.warehouse.models.Input;
import qr.warehouse.payload.InputDTO;
import qr.warehouse.services.InputService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/input")
public class InputController {

    private final InputService service;

    @PostMapping
    private Result addInput(@RequestBody InputDTO inputDTO) {
        return service.addInput(inputDTO);
    }

    @GetMapping
    private List<Input> getInputs() {
        return service.getInputs();
    }

    @GetMapping("/{inputId}")
    private Input getInputById(@PathVariable Long inputId) {
        return service.getInputById(inputId);
    }

    @PutMapping("/{inputId}")
    private Result updateInput(@PathVariable Long inputId,
                               @RequestBody InputDTO inputDTO) {
        return service.updateProduct(inputId, inputDTO);
    }

    @DeleteMapping("/{inputId}")
    private Result deleteInputById(@PathVariable Long inputId) {
        return service.deleteInput(inputId);
    }

}