package com.abc.springwebflux.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="product")
public class Product {

	@Id	
	private long id;
	
	@Column("product_name")	
	private String productName;
	
	@Column("product_price")	
	private double productPrice;
	
	private LocalDate mfd;
	
	private String category;
}
