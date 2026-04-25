package com.example.tripease.service;

import com.example.tripease.Enum.TripStatus;
import com.example.tripease.dto.request.BookingRequest;
import com.example.tripease.dto.response.BookingResponse;
import com.example.tripease.exception.NotAvailableCab;
import com.example.tripease.exception.customerNotFoundException;
import com.example.tripease.model.Booking;
import com.example.tripease.model.Cab;
import com.example.tripease.model.Customer;
import com.example.tripease.model.Driver;
import com.example.tripease.repository.BookingRepository;
import com.example.tripease.repository.CabRepository;
import com.example.tripease.repository.CustomerRepository;
import com.example.tripease.repository.DriverRepository;
import com.example.tripease.transfer.BookingTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CabRepository cabRepository;
    @Autowired
    DriverRepository driverRepository;
    @Autowired
    JavaMailSender javaMailSender;
    public BookingResponse addBooking(BookingRequest bookingRequest, int customerId) {
        Optional<Customer> optionalCustomer =customerRepository.findById(customerId);
        if(optionalCustomer.isEmpty())
            throw new customerNotFoundException("Invalid Customer Id");
        Customer customer=optionalCustomer.get();
        Cab availableCab=cabRepository.cabAvailableCabRandomly();
        if(availableCab==null)
            throw  new NotAvailableCab("Sorry Cab is not available");
        Booking booking= BookingTransfer.bookingRequestToBooking(bookingRequest,availableCab.getRatePerKm());
        booking.setBookingTime(LocalDateTime.now());
        Booking savedBooking=bookingRepository.save(booking);
        availableCab.setAvailable(false);
        customer.getBooking().add(savedBooking);
        Driver driver=driverRepository.getDriverByCabId(availableCab.getCabId());
        booking.setDriver(driver);
        driver.getBooking().add(savedBooking);
        Customer customer1= customerRepository.save(customer);
        Driver driver1=driverRepository.save(driver);
        sendSimpleMessage(customer1);
        return  BookingTransfer.bookingToBookingResponse(savedBooking,customer1,availableCab,driver1);
    }
    public void sendSimpleMessage(Customer customer){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("dspring649@gmail.com");
        message.setTo(customer.getEmailId());
        message.setSubject("Cab Booked");
        message.setText("Congratulations"+customer.getName()+"Your cab has been Booked");
        javaMailSender.send(message);
    }
    public String calculateFare(LocalDate date) {
        List<Booking> bookings = bookingRepository.findByDate(date);
        if(bookings.isEmpty())
            throw new RuntimeException("Booking is not available for this date");
        Booking finalBooking = bookings.get(0);
        String ans = "Distance between "
                + finalBooking.getPickUp()
                + " to "
                + finalBooking.getDestination()
                + " and fare amount is "
                + finalBooking.getBillAmount()
                + " total distance "
                + finalBooking.getTripDistanceInKm();
        return ans;
    }

    public String bookCabWithSchedule(Booking booking, LocalDate time) {
         Cab cabAvailable=cabRepository.cabAvailableCabRandomly();
         if(cabAvailable==null)
             throw  new RuntimeException("Cab is not available ");
         cabAvailable.setAvailable(false);
         Driver driver=driverRepository.getDriverByCabId(cabAvailable.getCabId());
         bookingRepository.save(booking);
         return "You have Sucessfully Book your cab with time +";
    }


    public String completeBooking(int bookingId) {
        Optional<Booking> booking=bookingRepository.findById(bookingId);
        if(booking.isEmpty())
           throw  new RuntimeException("Booking not found");
        Booking updateBooking=booking.get();
        updateBooking.setDropTime(LocalDateTime.now());
        updateBooking.setTripStatus(TripStatus.Completed);
        Optional<Booking> savedBooking= Optional.of(bookingRepository.save(updateBooking));
        return  "This booking has completed";

    }
}
