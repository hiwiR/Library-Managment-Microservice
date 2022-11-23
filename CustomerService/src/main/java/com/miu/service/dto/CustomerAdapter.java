package com.miu.service.dto;

import com.miu.domain.Customer;

public class CustomerAdapter {

    public static CustomerDto getCustomerDto(Customer customer){
        CustomerDto customerDto = new CustomerDto(
                customer.getCustomerNumber(),
                customer.getFirstName(),
                customer.getLastName()
        );
        return customerDto;
    }

    public static Customer getCustomer(CustomerDto customerDto){
        Customer customer = new Customer(
             customerDto.getCustomerNumber(),
                customerDto.getFirstName(),
             customerDto.getLastName()
        );
        return customer;
    }
}
