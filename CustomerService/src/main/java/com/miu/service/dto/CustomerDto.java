package com.miu.service.dto;

import com.miu.domain.Address;
import com.miu.domain.Contact;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private Integer customerNumber;
    private String firstName;
    private String lastName;


}
