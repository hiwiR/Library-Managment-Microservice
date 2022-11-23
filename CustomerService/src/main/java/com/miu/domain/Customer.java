package com.miu.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Customer {

    @Id
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
