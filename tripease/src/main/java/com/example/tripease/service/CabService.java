package com.example.tripease.service;

import com.example.tripease.dto.request.CabRequest;
import com.example.tripease.dto.response.CabResponse;
import com.example.tripease.exception.driverNotFound;
import com.example.tripease.model.Booking;
import com.example.tripease.model.Cab;
import com.example.tripease.model.Driver;


import com.example.tripease.repository.BookingRepository;
import com.example.tripease.repository.CabRepository;
import com.example.tripease.repository.DriverRepository;
import com.example.tripease.transfer.CabTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class CabService {

    @Autowired
    DriverRepository driverRepository;

    @Autowired
    BookingRepository bookingRepository;
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
    public List<Cab> FindCabsMorethanThoundKm(int range) {

        List<Driver> drivers = driverRepository.FindDriversMorethanThoundKm(range);
        if(drivers.isEmpty())
            throw new RuntimeException("No Cabs available for this range");
        List<Cab> cabList = new ArrayList<>();

        for(Driver driver : drivers) {
            cabList.add(driver.getCab());
        }

        return cabList;
    }
}
