package com.abc.springwebflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.springwebflux.entity.Product;
import com.abc.springwebflux.service.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductService productService;
		
	@PostMapping("/")
	public ResponseEntity<Mono<Product>> addNewProduct(@RequestBody Product product) {		
		Mono<Product> monoProduct = productService.saveProduct(product);		
		return new ResponseEntity<>(monoProduct,HttpStatus.CREATED);
	}
	
	@GetMapping("/{productId}")
	public ResponseEntity<Mono<Product>> fetchProductDetails(@PathVariable int productId) {
		Mono<Product> monoProduct = productService.findProductDetails(productId);
		return new ResponseEntity<>(monoProduct,HttpStatus.OK);
	}
	
	@GetMapping("/")
	public Flux<Product> fetchAllProducts() {
		return productService.findAllProducts();
	}

}
