package com.example.tripease.dto.response;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class CabResponse {
    private String cabNumber;
    private String cabModel;
    private  float ratePerKm;
    private boolean isAvailable;
    private DriverResponse driverResponse;

}
