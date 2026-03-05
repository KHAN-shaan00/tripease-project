package com.example.tripease.transfer;

import com.example.tripease.Enum.TripStatus;
import com.example.tripease.dto.request.BookingRequest;
import com.example.tripease.dto.response.BookingResponse;
import com.example.tripease.model.Booking;
import com.example.tripease.model.Cab;
import com.example.tripease.model.Customer;
import com.example.tripease.model.Driver;

public class BookingTransfer {
    public static Booking bookingRequestToBooking(BookingRequest bookingRequest,double ratePerKm){
        return Booking.builder()
                .pickUp(bookingRequest.getPickUp())
                .destination(bookingRequest.getDestination())
                .tripDistanceInKm(bookingRequest.getTripDistanceInKm())
                .tripStatus(TripStatus.OnGoing)
                .billAmount(bookingRequest.getTripDistanceInKm()*ratePerKm)
                .build();
    }
    public static BookingResponse bookingToBookingResponse(Booking booking, Customer customer, Cab cab, Driver driver){
        return BookingResponse.builder()
                .pickUp(booking.getPickUp())
                .destination(booking.getDestination())
                .tripDistanceInKm(booking.getTripDistanceInKm())
                .tripStatus(TripStatus.Completed)
                .billAmount(booking.getTripDistanceInKm()*cab.getRatePerKm())
                .customerResponse(CustomerTransfer.cutomerToCustomerRespons(customer))
                .cabResponse(CabTransfer.cabToCabResponse(cab,driver))
                .build();
    }
}
