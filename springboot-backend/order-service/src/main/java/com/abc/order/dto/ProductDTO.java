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
public class ProductDTO {

	private long id;
	private String productName;
	private double productPrice;
	private LocalDate mfd;
	private String category;
	@Override
	public String toString() {
		return "ProductDTO{" +
				"id=" + id +
				", productName='" + productName + '\'' +
				", productPrice=" + productPrice +
				", mfd=" + mfd +
				", category='" + category + '\'' +
				'}';
	}
}
