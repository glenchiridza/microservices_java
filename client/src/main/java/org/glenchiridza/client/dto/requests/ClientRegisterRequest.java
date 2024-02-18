package org.glenchiridza.client.dto.requests;


import lombok.Data;

@Data
public class ClientRegisterRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private Boolean isDeliveryReceived;

}
