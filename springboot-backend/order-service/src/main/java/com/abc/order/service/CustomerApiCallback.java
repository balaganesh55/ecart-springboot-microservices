package com.abc.order.service;

import org.springframework.stereotype.Component;

import com.abc.order.dto.CustomerDTO;

@Component
public class CustomerApiCallback implements CustomerApiClient {

	@Override
	public CustomerDTO getCustomerDetails(long customerId) {
		// TODO Auto-generated method stub
		return new CustomerDTO();
	}

}
