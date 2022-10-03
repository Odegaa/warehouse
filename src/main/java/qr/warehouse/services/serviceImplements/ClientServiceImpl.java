package qr.warehouse.services.serviceImplements;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import qr.warehouse.finaly.Result;
import qr.warehouse.models.Client;
import qr.warehouse.repositories.ClientRepository;
import qr.warehouse.services.ClientService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;

    @Override
    public Result addNewClient(Client client) {
        try {
            boolean clientByPhoneNumber = repository.existsClientByPhoneNumber(client.getPhoneNumber());
            if (clientByPhoneNumber) {
                return new Result("This phone number already exist", false);
            } else {
                Client newClient = new Client();
                newClient.setSurname(client.getSurname());
                newClient.setName(client.getName());
                newClient.setPhoneNumber(client.getPhoneNumber());

                repository.save(newClient);
                return new Result("Successfully saved new Client", true);
            }
        } catch (Exception e) {
            return new Result("An error occurred", false);
        }
    }

    @Override
    public List<Client> getClientList() {
        return repository.findAll();
    }

    @Override
    public Result updateClient(Long clientId, Client client) {
        Optional<Client> optionalClient = repository.findById(clientId);
        if (optionalClient.isPresent()) {
            Client updatingClient = optionalClient.get();

            updatingClient.setSurname(client.getSurname());
            updatingClient.setName(client.getName());
            updatingClient.setPhoneNumber(client.getPhoneNumber());

            repository.save(updatingClient);
            return new Result("Successfully updated!", true);
        }
        return new Result("Client not found or Exception", false);
    }

    @Override
    public Result deleteClient(Long clientId) {
        Optional<Client> optionalClient = repository.findById(clientId);
        if (optionalClient.isPresent()) {
            repository.deleteById(clientId);
            return new Result("Client deleted!", true);
        } else
            return new Result("Client not found or Exception!", false);
    }

    @Override
    public Client getClientById(Long clientId) {
        return repository.findById(clientId).orElse(null);
    }
}