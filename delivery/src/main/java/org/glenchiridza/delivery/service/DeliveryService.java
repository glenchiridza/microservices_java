package org.glenchiridza.delivery.service;


import ch.qos.logback.core.net.server.Client;
import org.glenchiridza.client.service.ClientService;
import org.glenchiridza.delivery.model.Delivery;
import org.glenchiridza.delivery.repository.DeliveryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;


    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public boolean receivedDelivery(Integer clientId, boolean isReceived){

        Delivery delivery = Delivery.builder()
                .deliveryCompany("Glen Inc")
                .clientId(clientId)
                .receivedDelivery(isReceived)
                .createdAt(LocalDateTime.now())
                .build();
        deliveryRepository.save(delivery);
        return isReceived;
    }
}
