package com.example.tripease.controller;

import com.example.tripease.dto.request.BookingRequest;
import com.example.tripease.dto.response.BookingResponse;
import com.example.tripease.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    BookingService bookingService;
    @PostMapping("/bookingCab/{id}")
    public BookingResponse addBooking(@RequestBody BookingRequest bookingRequest,
                                            @PathVariable("id") int customer_id){
        return bookingService.addBooking(bookingRequest,customer_id);
    }
}
