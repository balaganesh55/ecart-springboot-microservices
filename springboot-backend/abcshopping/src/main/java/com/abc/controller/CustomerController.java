package com.abc.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.dto.CustomerDTO;
import com.abc.service.CustomerService;

@CrossOrigin(value = "http://localhost:4200/")
@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/")
	public ResponseEntity<CustomerDTO> addCustomer(@RequestBody CustomerDTO customerDTO) {

		customerDTO = customerService.saveCustomer(customerDTO);

		return new ResponseEntity<>(customerDTO, HttpStatus.CREATED);
	}

	@GetMapping("/{customerId}")
	public ResponseEntity<CustomerDTO> fetchCustomerDetails(@PathVariable long customerId) {

		CustomerDTO customerDTO = customerService.findCustomerById(customerId);

		return new ResponseEntity<>(customerDTO, HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<Set<CustomerDTO>> fetchAllCustomers() {

		Set<CustomerDTO> customers = customerService.findAllCustomers();

		return new ResponseEntity<>(customers, HttpStatus.OK);
	}

	@PutMapping("/")
	public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customer) {
		CustomerDTO dto = customerService.updateCustomerById(customer);
		return new ResponseEntity<CustomerDTO>(dto, HttpStatus.OK);
	}

	@DeleteMapping("/{customerId}")
	public ResponseEntity<CustomerDTO> deleteCustomer(@PathVariable long customerId) {
		customerService.deleteCustomerById(customerId);
		return new ResponseEntity<CustomerDTO>(HttpStatus.OK);
	}
}
