package com.springboot.accounts.service.impl;

import com.springboot.accounts.dto.CustomerDetailsDto;
import com.springboot.accounts.dto.CustomerDto;
import com.springboot.accounts.entity.Accounts;
import com.springboot.accounts.entity.Customer;
import com.springboot.accounts.exception.ResourceNotFoundException;
import com.springboot.accounts.mapper.CustomerMapper;
import com.springboot.accounts.repository.AccountsRepository;
import com.springboot.accounts.repository.CustomerRepository;
import com.springboot.accounts.service.ICustomersService;
import com.springboot.accounts.service.client.CardsFeignClient;
import com.springboot.accounts.service.client.LoansFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomersServiceImpl implements ICustomersService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;
    @Override
    public CustomerDto fetchCustomerDetails(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "Mobile Number", mobileNumber)
        );

        Accounts account = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "CustomerId", customer.getCustomerId().toString())
        );

        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
    }
}
