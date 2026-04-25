package com.example.tripease.model;

import com.example.tripease.Enum.TripStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

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
    @Enumerated(EnumType.STRING)
    private TripStatus tripStatus;
    private double billAmount;
    private LocalDateTime scheduledTime;
    private LocalDateTime bookingTime;
    private LocalDateTime dropTime;
    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;
}