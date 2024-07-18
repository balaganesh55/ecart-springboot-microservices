package com.abc.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.abc.order.dto.ProductDTO;

@FeignClient(value="PRODUCT-SERVICE")
public interface ProductApiClient {

	@GetMapping("/product/{productId}")
	ProductDTO fetchProductDetails(@PathVariable long productId);
}
