package com.example.tripease.transfer;

import com.example.tripease.dto.request.CabRequest;
import com.example.tripease.dto.response.CabResponse;
import com.example.tripease.model.Cab;
import com.example.tripease.model.Driver;

public class CabTransfer {
    public static Cab cabRequestToCab(CabRequest cabRequest){
        return Cab.builder().cabNumber(cabRequest.getCabNumber())
                .cabModel(cabRequest.getCabModel())
                .isAvailable(true)
                .ratePerKm(cabRequest.getRatePerKm()).build();
    }
    public  static CabResponse cabToCabResponse(Cab cab, Driver driver){
       return CabResponse.builder().cabNumber(cab.getCabNumber())
                .cabModel(cab.getCabModel())
                .ratePerKm(cab.getRatePerKm())
                .isAvailable(cab.isAvailable())
                .driverResponse(DriverTransfer.driverTodriverResponse(driver))
                .build();

    }


}
