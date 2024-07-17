package com.abc.order.dto;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
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
    @Override
    public String toString() {
        return "CustomerDTO{" +
                "city='" + city + '\'' +
                ", customerName='" + customerName + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}