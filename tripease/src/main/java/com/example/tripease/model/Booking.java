package com.example.tripease.model;

import com.example.tripease.Enum.TripStatus;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Builder
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer booking_id;
    private String pickUp;
    private String destination;
    private double tripDistanceInKm;
    @Enumerated(value = EnumType.STRING)
    private TripStatus tripStatus;
    private double billAmount;


}
