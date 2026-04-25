package com.example.tripease.controller;

import com.example.tripease.dto.request.CabRequest;
import com.example.tripease.dto.response.CabResponse;
import com.example.tripease.model.Cab;
import com.example.tripease.service.CabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cab")
public class CabController {
    @Autowired
    CabService cabService;

    @PostMapping("/add/{id}")
    public CabResponse addCab(@RequestBody CabRequest cabRequest,
                              @PathVariable("id") int driver_id){
       return cabService.addCab(cabRequest,driver_id);
    }
    @GetMapping("/findCabs/{range}")
    public List<Cab> FindCabsMorethanThoundKm(@PathVariable int range){
        return cabService.FindCabsMorethanThoundKm(range);
    };
}
