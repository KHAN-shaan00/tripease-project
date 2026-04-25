package com.example.tripease.controller;


import com.example.tripease.dto.request.DriverRequest;
import com.example.tripease.dto.response.DriverResponse;

import com.example.tripease.model.Driver;
import com.example.tripease.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driver")
public class DriverController {
    @Autowired
    DriverService driverService;
    @PostMapping("/add")
    public DriverResponse addDriver(@RequestBody DriverRequest driverRequest){
       return driverService.addDriver(driverRequest);
    }
    @GetMapping("/getAllDriver")
    public List<DriverResponse> getAllDrivers(){
        return driverService.getAllDrivers();
    }

    @GetMapping("/countTrip/{driver_id}")
    public int countTripOfDriver(@PathVariable int driver_id){
        return driverService.countTripOfDriver(driver_id);
    }
}
