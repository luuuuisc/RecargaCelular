package com.luiz.RecargaAlgar.Service;

import com.luiz.RecargaAlgar.Entity.Client;
import com.luiz.RecargaAlgar.Repository.ClientRepository;
import com.luiz.RecargaAlgar.dto.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client createClient(ClientDTO clientDTO) {
        Client client = new Client();
        client.setName(clientDTO.getName());
        client.setPhoneNumber(clientDTO.getPhoneNumber());
        return clientRepository.save(client);
    }

    public ClientDTO getClientById(Long id) {
        return clientRepository.findById(id)
                .map(client -> new ClientDTO(client))  // Supondo que ClientDTO tem um construtor que aceita Client
                .orElse(null);
    }


    public Client updateClient(Long id, ClientDTO clientDTO) {
        return clientRepository.findById(id)
                .map(client -> {
                    client.setName(clientDTO.getName());
                    client.setPhoneNumber(clientDTO.getPhoneNumber());
                    return clientRepository.save(client);
                }).orElseThrow(() -> new RuntimeException("Client not found"));
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}

