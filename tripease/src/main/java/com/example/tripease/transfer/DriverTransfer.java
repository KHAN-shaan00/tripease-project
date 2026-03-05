package com.example.tripease.transfer;

import com.example.tripease.dto.request.DriverRequest;
import com.example.tripease.dto.response.DriverResponse;
import com.example.tripease.model.Driver;

public class DriverTransfer {
    public static Driver driverRequestToDriver(DriverRequest driverRequest){
        return Driver.builder()
                .name(driverRequest.getName())
                .age(driverRequest.getAge())
                .emailId(driverRequest.getEmailId())
                .build();
    }
    public static DriverResponse driverTodriverResponse(Driver driver){
        return DriverResponse.builder()
                .driver_id(driver.getDriver_id())
                .name(driver.getName())
                .age(driver.getAge())
                .emailId(driver.getEmailId())
                .build();
    }
}
