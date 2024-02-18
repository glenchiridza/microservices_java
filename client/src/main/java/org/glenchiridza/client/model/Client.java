package org.glenchiridza.client.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Client {

    @Id
    @GeneratedValue(generator = "client_sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "client_sequence",sequenceName = "client_sequence")
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;

    private Boolean isDeliveryReceived = false;
}
