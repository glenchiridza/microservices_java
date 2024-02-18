package org.glenchiridza.delivery.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Delivery {

    @Id
    @GeneratedValue(generator = "sequence_delivery",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequence_delivery",sequenceName = "sequence_delivery")
    private Integer id;
    private Integer clientId;
    private String deliveryCompany;
    private Boolean receivedDelivery;
    private LocalDateTime createdAt;
}
