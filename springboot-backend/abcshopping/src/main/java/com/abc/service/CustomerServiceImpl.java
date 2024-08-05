package com.abc.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.dto.CustomerDTO;
import com.abc.entity.Customer;
import com.abc.exception.ResourceNotFoundException;
import com.abc.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CustomerDTO saveCustomer(CustomerDTO customerDTO) {

		Customer customer = modelMapper.map(customerDTO, Customer.class);

		customerRepository.save(customer);

		customerDTO = modelMapper.map(customer, CustomerDTO.class);
		return customerDTO;
	}

	@Override
	public CustomerDTO findCustomerById(long customerId) {

		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
		if (optionalCustomer.isEmpty()) {
			throw new ResourceNotFoundException("Customer not found with id: " + customerId);
		}
		Customer customer = optionalCustomer.get();

		CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);
		return customerDTO;
	}

	@Override
	public Set<CustomerDTO> findAllCustomers() {

		List<Customer> customers = customerRepository.findAll();

		return customers.stream().map(customer -> modelMapper.map(customer, CustomerDTO.class))
				.collect(Collectors.toSet());
	}

	@Override
	public CustomerDTO updateCustomerById(CustomerDTO customerDto) {
		Optional<Customer> optionalCustomer = customerRepository.findById(customerDto.getId());
		if (optionalCustomer.isEmpty()) {
			throw new ResourceNotFoundException("Customer not found with id ");
		}
		Customer customer = optionalCustomer.get();
		Customer customer1 = modelMapper.map(customerDto, Customer.class);
		customer.setCity(customer1.getCity());
		customer.setCustomerName(customer1.getCustomerName());
		customer.setDob(customer1.getDob());
		customer.setEmail(customer1.getEmail());
		customer.setMobile(customer1.getMobile());
		customer.setOrders(customer1.getOrders());
		Customer customer2 = customerRepository.save(customer);
		return modelMapper.map(customer2, CustomerDTO.class);
	}

	@Override
	public void deleteCustomerById(long customerId) {

		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
		if (optionalCustomer.isEmpty()) {
			throw new ResourceNotFoundException("Customer not found with id: " + customerId);
		}
		Customer customer = optionalCustomer.get();
		customerRepository.delete(customer);

	}

}
