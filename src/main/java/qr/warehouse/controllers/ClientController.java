package qr.warehouse.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import qr.warehouse.finaly.Result;
import qr.warehouse.models.Client;
import qr.warehouse.services.ClientService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {

    private final ClientService service;

    @PostMapping
    private Result addClient(@RequestBody Client client) {
        return service.addNewClient(client);
    }

    @GetMapping
    private List<Client> getClients() {
        return service.getClientList();
    }

    @GetMapping("/{clientId}")
    private Client getClientById(@PathVariable Long clientId) {
        return service.getClientById(clientId);
    }

    @PutMapping("/{clientId}")
    private Result updateClient(@PathVariable Long clientId,
                                @RequestBody Client client) {
        return service.updateClient(clientId, client);
    }

    @DeleteMapping("/{clientId}")
    private Result deleteClient(@PathVariable Long clientId) {
        return service.deleteClient(clientId);
    }
}