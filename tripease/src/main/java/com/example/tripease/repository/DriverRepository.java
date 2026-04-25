package com.example.tripease.repository;

import com.example.tripease.model.Booking;
import com.example.tripease.model.Cab;
import com.example.tripease.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver,Integer> {

    @Query(value = "select * from driver where cab_cab_id=:cabId",nativeQuery = true)
    Driver getDriverByCabId(@Param("cabId") Integer cabId);

    @Query(value = """
        SELECT d.*
        FROM driver d
        INNER JOIN booking b
        ON d.driver_id = b.driver_id
        GROUP BY d.driver_id
        HAVING SUM(b.trip_distance_in_km) > :range
        """, nativeQuery = true)
    List<Driver> FindDriversMorethanThoundKm(@Param("range") int range);
}
