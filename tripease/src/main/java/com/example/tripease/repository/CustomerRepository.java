package com.example.tripease.repository;

import com.example.tripease.Enum.Gender;
import com.example.tripease.model.Customer;
import com.example.tripease.transfer.CustomerTransfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer findFirstByName(String name);
    List<Customer> findByName(String name);
    List<Customer> findByNameAndGender(String name, Gender gender);

    @Query("select c from Customer c where c.name=:name and c.gender=:gender")
    List<Customer> getByNameAndGenderQ(@Param("name") String name,@Param("gender")Gender gender);
}
