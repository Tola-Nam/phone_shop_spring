package com.tola.dev.phoneShope.service;

import com.tola.dev.phoneShope.entity.Products;

public interface ProductService {
	Products createProducts(Products products);
	Products getById(Long id);
}
