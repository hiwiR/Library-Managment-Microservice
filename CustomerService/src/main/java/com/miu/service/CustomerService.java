package com.miu.service;

import com.miu.domain.Customer;
import com.miu.service.dto.CustomerDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {
    void add(Customer customer);

    boolean customerExsist(int customerNumber);

    CustomerDto findCustomer(int customerNumber);

    void deleteCustomer(int customerNumber);

    List<CustomerDto> getAll();
    public void update(Customer customer);
}
