package com.example.tripease.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Cab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer cabId;
    private String cabNumber;
    private String cabModel;
    private  float ratePerKm;
    private boolean isAvailable;
}
