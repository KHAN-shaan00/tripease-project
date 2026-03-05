package com.example.tripease.repository;

import com.example.tripease.model.Booking;
import com.example.tripease.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DriverRepository extends JpaRepository<Driver,Integer> {

    @Query(value = "select * from driver where cab_cab_id=:cabId",nativeQuery = true)
    Driver getDriverByCabId(@Param("cabId") Integer cabId);


}
