package org.glenchiridza.client.service;

import org.glenchiridza.client.dto.requests.ClientRegisterRequest;
import org.glenchiridza.client.dto.responses.DeliveryResponse;
import org.glenchiridza.client.model.Client;
import org.glenchiridza.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class ClientService {


    private final ClientRepository clientRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public ClientService(ClientRepository clientRepository, RestTemplate restTemplate) {
        this.clientRepository = clientRepository;
        this.restTemplate = restTemplate;
    }

    public void registerClient(ClientRegisterRequest requestDto) {
        Client client = Client.builder()
                .firstName(requestDto.getFirstName())
                .lastName(requestDto.getLastName())
                .email(requestDto.getEmail())
                .phone(requestDto.getPhone())
                .address(requestDto.getAddress())
                .isDeliveryReceived(requestDto.getIsDeliveryReceived())
                .build();



        clientRepository.saveAndFlush(client); //so we have the clientId immediately
        //check delivery
        DeliveryResponse deliveryResponse = restTemplate.getForObject(
                "http://localhost:8081/api/v1/delivery/{clientId}/{received}",
                DeliveryResponse.class,
                client.getId(),
                client.getIsDeliveryReceived()
        );

        if(deliveryResponse.isReceivedDelivery()){
            throw new IllegalStateException("Client already received delivery from us");
        }
    }

    public Client getExistingClient(Integer clientId){

        Optional<Client> client = clientRepository.findById(clientId);

        return client.orElseThrow(()-> new IllegalStateException("client with specified id: "+clientId+" : was not found"));
    }
}
