package org.glenchiridza.delivery.controller;


import org.glenchiridza.delivery.dto.responses.DeliveryResponse;
import org.glenchiridza.delivery.model.Delivery;
import org.glenchiridza.delivery.service.DeliveryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/delivery")
public class DeliveryController {

    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping("/{clientId}/{received}")
    public ResponseEntity<DeliveryResponse> receivedDelivery(@PathVariable("clientId") Integer id,
                                           @PathVariable("received") boolean isReceived){
        boolean isDeliveryReceived = deliveryService.receivedDelivery(id,isReceived);
        DeliveryResponse deliveryResponse = new DeliveryResponse();
        deliveryResponse.setReceivedDelivery(isDeliveryReceived);

        return new ResponseEntity<>(deliveryResponse, HttpStatus.OK);

    }
}
