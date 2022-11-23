package com.miu.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class Customer {

    private Integer customerNumber;
    private String firstName;
    private String lastName;
    private Contact contact;
    private Address address;

    public Customer(int customerNumber,String firstName,String lastName){

        this.firstName = firstName;
        this.customerNumber = customerNumber;
        this.lastName = lastName;
    }

}
