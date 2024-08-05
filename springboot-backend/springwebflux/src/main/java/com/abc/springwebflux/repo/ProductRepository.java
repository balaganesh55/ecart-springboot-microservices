package com.abc.springwebflux.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.abc.springwebflux.entity.Product;

public interface ProductRepository extends ReactiveCrudRepository<Product,Long>{

}
