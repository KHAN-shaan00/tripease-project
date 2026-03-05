package com.example.tripease.service;

import com.example.tripease.Enum.Gender;
import com.example.tripease.dto.request.CustomerRequest;
import com.example.tripease.dto.response.CustomerResponse;
import com.example.tripease.exception.customerNotFoundException;
import com.example.tripease.model.Customer;
import com.example.tripease.repository.CustomerRepository;
import com.example.tripease.transfer.CustomerTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
        Customer newCustomer= CustomerTransfer.customerRequestToCostomer(customerRequest);
        Customer getCustomer=customerRepository.save(newCustomer);
        return CustomerTransfer.cutomerToCustomerRespons(getCustomer);
    }

    public CustomerResponse getCustomer(int customerId) {
        Optional<Customer> optionalCustomer= customerRepository.findById(customerId);
        if(optionalCustomer.isEmpty())
             throw new customerNotFoundException("InValid Customer Id");
        else {
            Customer getCustomer= optionalCustomer.get();
            return CustomerTransfer.cutomerToCustomerRespons(getCustomer);
        }

    }
    public List<CustomerResponse> getCustomerByName(String name) {
        List<Customer> customers=customerRepository.findByName(name);
        List<CustomerResponse> customerResponses= new ArrayList<>();
        for(Customer customer: customers){
            customerResponses.add(CustomerTransfer.cutomerToCustomerRespons(customer));
        }
        return customerResponses;
    }

    public List<CustomerResponse> getByNameAndGender(String name, Gender gender) {
        List<Customer> customers=customerRepository.findByNameAndGender(name,gender);
        List<CustomerResponse> customerResponses= new ArrayList<>();
        for(Customer customer: customers){
            customerResponses.add(CustomerTransfer.cutomerToCustomerRespons(customer));
        }
        return customerResponses;

    }
    public List<CustomerResponse> getByNameAndGenderQ(String name, Gender gender) {
        List<Customer> customers=customerRepository.getByNameAndGenderQ(name,gender);
        List<CustomerResponse> customerResponses= new ArrayList<>();
        for(Customer customer: customers){
            customerResponses.add(CustomerTransfer.cutomerToCustomerRespons(customer));
        }
        return customerResponses;
    }

    public CustomerResponse updateByName(String name, CustomerRequest customerRequest) {
        Customer newCustomer= CustomerTransfer.customerRequestToCostomer(customerRequest);
        Customer findCustomer = customerRepository.findFirstByName(name);
        findCustomer.setName(newCustomer.getName());
        return CustomerTransfer.cutomerToCustomerRespons( customerRepository.save(findCustomer));
    }


}
