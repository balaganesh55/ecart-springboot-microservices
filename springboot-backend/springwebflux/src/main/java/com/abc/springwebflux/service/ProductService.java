package com.abc.springwebflux.service;

import com.abc.springwebflux.entity.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {

	Mono<Product> saveProduct(Product product);
	
	Mono<Product> findProductDetails(long productId);
	
	Flux<Product> findAllProducts();
}
