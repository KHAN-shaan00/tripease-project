package com.example.tripease.repository;

import com.example.tripease.model.Booking;
import com.example.tripease.model.Cab;
import com.example.tripease.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer> {

    @Query("SELECT b FROM Booking b WHERE DATE(b.bookingTime) = :date")
    List<Booking> findByDate(@Param("date") LocalDate date);


    @Query("Select count(b) from Booking b where b.driver.driver_id= :driverId and b.tripStatus='Completed'")
    int countTripOfDriver(@Param("driverId") int driverId);


}
