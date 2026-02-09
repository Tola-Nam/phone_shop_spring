package com.tola.dev.phoneShope.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tola.dev.phoneShope.dto.ProductDTO;
import com.tola.dev.phoneShope.entity.Products;
import com.tola.dev.phoneShope.mapper.ProductMapper;
import com.tola.dev.phoneShope.service.ProductService;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

	private final ProductService productService;
	private final ProductMapper productMapper;

	@PostMapping
	public ResponseEntity<?> createProductEntity(@Valid @RequestBody ProductDTO productDTO) {

		Products products = productMapper.toProducts(productDTO);

		return ResponseEntity.ok(productService.createProducts(products));
	}
}
