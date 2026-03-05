package com.example.tripease.controller;
import com.example.tripease.Enum.Gender;
import com.example.tripease.dto.request.CustomerRequest;
import com.example.tripease.dto.response.CustomerResponse;
import com.example.tripease.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @PostMapping("/add")
    public CustomerResponse addCustomer(@RequestBody CustomerRequest customerRequest){
        return customerService.addCustomer(customerRequest);
    }
    @GetMapping("/addCustomer/{id}")
    public CustomerResponse getCustomer(@PathVariable("id") int customerId){
        return  customerService.getCustomer(customerId);
    }
    @GetMapping("/getCustomerByName/{name}")
    public List<CustomerResponse> getCustomerByName(@PathVariable("name") String name){
        return  customerService.getCustomerByName(name);

    }
    @GetMapping("/getByNameAndGender/{name}/{gender}")
    public  List<CustomerResponse> getByNameAndGender(@PathVariable("name") String name,
                                                      @PathVariable("gender") Gender gender){
        return customerService.getByNameAndGender(name,gender);
    }
    @GetMapping("/getByNameAndGenderQ/{name}/{gender}")
    public  List<CustomerResponse> getByNameAndGenderQ(@PathVariable("name") String name,
                                                      @PathVariable("gender") Gender gender){
        return customerService.getByNameAndGenderQ(name,gender);
    }
    @PutMapping("updateName/{name}")
    public ResponseEntity<CustomerResponse> updateByName(@PathVariable("name") String name,
                                                         @RequestBody CustomerRequest customerRequestr){
        CustomerResponse customerResponse=  customerService.updateByName(name,customerRequestr);
        return  ResponseEntity.ok(customerResponse);
    }
}
