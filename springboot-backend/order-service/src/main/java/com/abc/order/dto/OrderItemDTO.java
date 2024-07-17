package com.abc.order.dto;

import java.time.LocalDate;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDTO {

	private long id;
	private double itemTotal;
	private int quantity;
	private long productId;

	private String productName;

	private double productPrice;

	private LocalDate mfd;

	private String category;
}
