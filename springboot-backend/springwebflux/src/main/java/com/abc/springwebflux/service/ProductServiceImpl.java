package com.abc.springwebflux.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.springwebflux.entity.Product;
import com.abc.springwebflux.exception.ResourceNotFoundException;
import com.abc.springwebflux.repo.ProductRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Mono<Product> saveProduct(Product product) {
		return productRepository.save(product);

	}

	@Override
	public Mono<Product> findProductDetails(long productId) {
		
		Mono<Product> monoProduct = productRepository.findById(productId).switchIfEmpty(Mono.error(new ResourceNotFoundException("Product not found")));
		
//		Product myProduct = new Product();
//				
//		monoProduct.subscribe(p-> {
//			var x = p.getProductPrice() * 0.05;
//			myProduct.setProductPrice(x);
//		});		
  
		return monoProduct;
	}

	@Override
	public Flux<Product> findAllProducts() {
		
		return productRepository.findAll();
	}

}
