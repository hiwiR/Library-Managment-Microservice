package com.miu.controller;

import com.miu.domain.Customer;
import com.miu.service.CustomerService;
import com.miu.service.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.POST;

@RestController
@RefreshScope
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

//    @Value("${message}")
//    private String messag;

    @GetMapping()
    public ResponseEntity<?> getAllCustomer(){
        return new ResponseEntity<>(customerService.getAll(),HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer){
        customerService.add(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @RequestMapping("/{customerNumber}")
    public CustomerDto getCustomers(@PathVariable int customerNumber){
        if(!customerService.customerExsist(customerNumber))
            return null;
           // return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            CustomerDto customerDto = customerService.findCustomer(customerNumber);
        return  customerDto;
    }
    @PutMapping()
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer){
        if(!customerService.customerExsist(customer.getCustomerNumber()))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        customerService.update(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{customerNumber}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int customerNumber){
        if(!customerService.customerExsist(customerNumber))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        customerService.deleteCustomer(customerNumber);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
