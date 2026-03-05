package com.example.tripease.service;

import com.example.tripease.dto.request.CabRequest;
import com.example.tripease.dto.response.CabResponse;
import com.example.tripease.exception.driverNotFound;
import com.example.tripease.model.Cab;
import com.example.tripease.model.Driver;


import com.example.tripease.repository.DriverRepository;
import com.example.tripease.transfer.CabTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CabService {

    @Autowired
    DriverRepository driverRepository;
    public CabResponse addCab(CabRequest cabRequest, int driverId) {
        Optional<Driver> optionalDriver=driverRepository.findById(driverId);
        if(optionalDriver.isEmpty())
            throw new driverNotFound("Invalid Driver");
        Driver driver=optionalDriver.get();
        Cab cab=CabTransfer.cabRequestToCab(cabRequest);
        driver.setCab(cab);
        Driver savedDriver=driverRepository.save(driver);
        return CabTransfer.cabToCabResponse(savedDriver.getCab(),savedDriver);
    }
}
