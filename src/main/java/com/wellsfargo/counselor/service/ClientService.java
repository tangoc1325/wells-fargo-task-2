package com.wellsfargo.counselor.service;

import com.wellsfargo.counselor.entity.Client;
import com.wellsfargo.counselor.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    /**
     * Updates an existing client's details.
     * @param id : The ID of the client to update.
     * @param updated : Client The client object containing updated details.
     * @return : The updated client, or null if not found.
     */
    public Client updateClient(Long id, Client updatedClient) {
        return clientRepository.findById(id).map(client -> {
            client.setAdvisorId(updatedClient.getAdvisorId());
            client.setFirstName(updatedClient.getFirstName());
            client.setLastName(updatedClient.getLastName());
            client.setAddress(updatedClient.getAddress());
            client.setPhone(updatedClient.getPhone());
            client.setEmail(updatedClient.getEmail());
            return clientRepository.save(client);
        }).orElse(null);
    }
} 