package com.miu.service;

import com.miu.data.CustomerRepository;
import com.miu.domain.Customer;
import com.miu.integration.KafkaSender;
import com.miu.service.dto.CustomerAdapter;
import com.miu.service.dto.CustomerDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService{

    private CustomerRepository customerRepository;
    private ModelMapper modelMapper;

    private KafkaSender kafkaSender;

    public CustomerServiceImpl(CustomerRepository customerRepository,ModelMapper modelMapper,
                               KafkaSender kafkaSender){
        this.customerRepository=customerRepository;
        this.modelMapper = modelMapper;
        this.kafkaSender = kafkaSender;
    }
    @Override
    public void add(Customer customer) {
        customerRepository.save(customer);

    }

    @Override
    public void update(Customer customer) {
        System.out.println("here");
        customerRepository.save(customer);
        CustomerDto customerDto = CustomerAdapter.getCustomerDto(customer);
                //modelMapper.map(customer,CustomerDto.class);
        kafkaSender.send("customerupdate",customerDto);
    }

    @Override
    public boolean customerExsist(int customerNumber) {
        return customerRepository.existsById(customerNumber);
    }

    @Override
    public CustomerDto findCustomer(int customerNumber) {
        Customer customer = customerRepository.findById(customerNumber).get();
        CustomerDto customerDto = CustomerAdapter.getCustomerDto(customer);
                //modelMapper.map(customer,CustomerDto.class);
        return customerDto;
    }
    @Override
    public void deleteCustomer(int customerNumber) {
        customerRepository.deleteById(customerNumber);
    }

    @Override
    public List<CustomerDto> getAll() {
        return customerRepository.findAll().stream().map(customer ->
                CustomerAdapter.getCustomerDto(customer)).collect(Collectors.toList());
                //modelMapper.map(customer,CustomerDto.class)).collect(Collectors.toList());
    }
}
