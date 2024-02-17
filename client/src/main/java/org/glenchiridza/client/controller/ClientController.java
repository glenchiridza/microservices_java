package org.glenchiridza.client.controller;

import lombok.extern.slf4j.Slf4j;
import org.glenchiridza.client.dto.requests.ClientRegisterRequest;
import org.glenchiridza.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/clients")
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public void clientRegistration(@RequestBody ClientRegisterRequest clientRequestDto){
        log.info("new client registration {} ",clientRequestDto);
        clientService.registerClient(clientRequestDto);
    }
}
