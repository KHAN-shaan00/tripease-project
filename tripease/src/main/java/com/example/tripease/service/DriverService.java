package com.example.tripease.service;

import com.example.tripease.dto.request.DriverRequest;
import com.example.tripease.dto.response.DriverResponse;
import com.example.tripease.model.Driver;
import com.example.tripease.repository.DriverRepository;
import com.example.tripease.transfer.DriverTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    @Autowired
    DriverRepository driverRepository;
    public DriverResponse addDriver(DriverRequest driverRequest) {
        Driver driver= DriverTransfer.driverRequestToDriver(driverRequest);
        return DriverTransfer.driverTodriverResponse(driverRepository.save(driver))  ;
    }
}
