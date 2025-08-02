package com.springboot.accounts.service;

import com.springboot.accounts.dto.CustomerDetailsDto;
import com.springboot.accounts.dto.CustomerDto;

public interface ICustomersService {

    CustomerDetailsDto fetchCustomerDetails(String mobileNumber, String correlationId);
}
