package com.springboot.accounts.service;

import com.springboot.accounts.dto.CustomerDto;

public interface ICustomersService {

    CustomerDto fetchCustomerDetails(String mobileNumber);
}
