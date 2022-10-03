package qr.warehouse.services;

import qr.warehouse.finaly.Result;
import qr.warehouse.models.Client;

import java.util.List;

public interface ClientService {


    Result addNewClient(Client client);

    List<Client> getClientList();

    Result updateClient(Long clientId, Client client);

    Result deleteClient(Long clientId);

    Client getClientById(Long clientId);
}
