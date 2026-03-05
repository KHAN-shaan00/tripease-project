package com.example.tripease.transfer;

import com.example.tripease.dto.request.CustomerRequest;
import com.example.tripease.dto.response.CustomerResponse;
import com.example.tripease.model.Customer;

public class CustomerTransfer {
    public static  Customer customerRequestToCostomer(CustomerRequest customerRequest){
        return Customer.builder().
                name(customerRequest.getName()).
                age(customerRequest.getAge()).
                emailId(customerRequest.getEmailId()).
                gender(customerRequest.getGender()).build();
    }
    public static CustomerResponse cutomerToCustomerRespons(Customer customer){
        return CustomerResponse.builder().
                name(customer.getName()).
                age(customer.getAge()).
                emailId(customer.getEmailId()).
                build();

    }
}
