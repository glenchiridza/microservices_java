package org.glenchiridza.client.service;

import org.glenchiridza.client.dto.requests.ClientRegisterRequest;
import org.glenchiridza.client.model.Client;
import org.glenchiridza.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {


    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void registerClient(ClientRegisterRequest requestDto) {
        Client client = Client.builder()
                .firstName(requestDto.getFirstName())
                .lastName(requestDto.getLastName())
                .email(requestDto.getEmail())
                .phone(requestDto.getPhone())
                .address(requestDto.getAddress())
                .build();

        clientRepository.save(client);
    }
}
