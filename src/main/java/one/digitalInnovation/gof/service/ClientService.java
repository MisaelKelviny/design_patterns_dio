package one.digitalInnovation.gof.service;

import one.digitalInnovation.gof.model.Client;

public interface ClientService {
    Iterable<Client> getAll();
    Client getById(Long id);
    void insert(Client client);
    void update(Long id, Client client);
    void delete(Long id);
}
