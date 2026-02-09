package com.tola.dev.phoneShope.service.impl;

import org.springframework.stereotype.Service;

import com.tola.dev.phoneShope.entity.Products;
import com.tola.dev.phoneShope.exception.ResourceNotFoundException;
import com.tola.dev.phoneShope.repository.ProductRepository;
import com.tola.dev.phoneShope.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	@Override
	public Products createProducts(Products products) {

		String name = "%s %s".formatted(products.getModels().getName(), products.getColor().getName());
		products.setName(name);
		return productRepository.save(products);
	}

	@Override
	public Products getById(Long id) {

		return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Products", id));
	}

}
