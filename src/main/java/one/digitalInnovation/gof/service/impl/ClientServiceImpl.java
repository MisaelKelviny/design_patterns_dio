package one.digitalInnovation.gof.service.impl;

import one.digitalInnovation.gof.model.Address;
import one.digitalInnovation.gof.model.AddressRepository;
import one.digitalInnovation.gof.model.Client;
import one.digitalInnovation.gof.model.ClientRepository;
import one.digitalInnovation.gof.service.ClientService;
import one.digitalInnovation.gof.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client getById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.get();
    }

    @Override
    public void insert(Client client) {
        saveClientOnDatabaseWithCep(client);
    }

    @Override
    public void update(Long id, Client client) {
        Optional<Client> clientDB = clientRepository.findById(id);
        if(clientDB.isPresent()){
            saveClientOnDatabaseWithCep(client);
        }
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    private void saveClientOnDatabaseWithCep(Client client) {
        String cep = client.getAddress().getCep();
        Address address = addressRepository.findById(cep).orElseGet(()-> {
            Address newAddress = viaCepService.getCep(cep);
            addressRepository.save(newAddress);
            return newAddress;
        });

        client.setAddress(address);
        clientRepository.save(client);
    }
}
