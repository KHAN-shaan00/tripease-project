package com.example.tripease.controller;
import com.example.tripease.dto.request.BookingRequest;
import com.example.tripease.dto.response.BookingResponse;
import com.example.tripease.model.Booking;
import com.example.tripease.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
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
    @GetMapping("/calculateFare/{date}")
    public String calculateFare( @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date ){
        return bookingService.calculateFare(date);
    }
    @PostMapping("bookCab/{time}")
    public String bookCabWithSchedule(@RequestBody Booking booking, @PathVariable @DateTimeFormat(iso=DateTimeFormat.ISO.TIME) LocalDate time){
        return bookingService.bookCabWithSchedule(booking,time);
    }
    @PutMapping("complete/{bookingId}")
    public String completeBooking(@PathVariable int bookingId){
        return bookingService.completeBooking(bookingId);
    }
}


