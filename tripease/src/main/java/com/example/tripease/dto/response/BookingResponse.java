package com.example.tripease.dto.response;


import com.example.tripease.Enum.TripStatus;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BookingResponse {
    private String pickUp;
    private String destination;
    private double tripDistanceInKm;
    private TripStatus tripStatus;
    private double billAmount;
    CustomerResponse customerResponse;
    CabResponse cabResponse;
}
