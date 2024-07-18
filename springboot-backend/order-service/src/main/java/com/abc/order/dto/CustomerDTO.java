package com.abc.order.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
	
	private long id;
	private String customerName;
	private LocalDate dob;
	private String mobile;
	private String email;
	private String city;
}
