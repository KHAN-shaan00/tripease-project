package com.example.tripease.service;

import com.example.tripease.dto.request.DriverRequest;
import com.example.tripease.dto.response.CustomerResponse;
import com.example.tripease.dto.response.DriverResponse;
import com.example.tripease.model.Customer;
import com.example.tripease.model.Driver;
import com.example.tripease.repository.BookingRepository;
import com.example.tripease.repository.DriverRepository;
import com.example.tripease.transfer.CustomerTransfer;
import com.example.tripease.transfer.DriverTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DriverService {

    @Autowired
    DriverRepository driverRepository;

    @Autowired
    BookingRepository bookingRepository;
    public DriverResponse addDriver(DriverRequest driverRequest) {
        Driver driver= DriverTransfer.driverRequestToDriver(driverRequest);
        return DriverTransfer.driverTodriverResponse(driverRepository.save(driver))  ;
    }

    public int countTripOfDriver(int driverId) {
           return bookingRepository.countTripOfDriver(driverId);
    }

    public List<DriverResponse> getAllDrivers() {
        List<Driver> drivers= driverRepository.findAll();
        List<DriverResponse> driverResponses = new ArrayList<>();
        for(Driver driver: drivers){
            driverResponses.add(DriverTransfer.driverTodriverResponse(driver));
        }
        return driverResponses;
    }
}
