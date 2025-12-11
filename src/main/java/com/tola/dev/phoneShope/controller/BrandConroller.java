package com.tola.dev.phoneShope.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tola.dev.phoneShope.dto.BrandDTO;
import com.tola.dev.phoneShope.entity.Brands;
import com.tola.dev.phoneShope.service.BrandService;
import com.tola.dev.phoneShope.service.util.Mapper;

@RestController
@RequestMapping("brands")
public class BrandConroller {

	@Autowired
	private BrandService brandService;
	@PostMapping
	public ResponseEntity<?> create(@RequestBody BrandDTO brandDTO) {
		Brands brands = Mapper.toBrand(brandDTO);
		brands = brandService.CreateBrand(brands);
		return ResponseEntity.ok(brands);
	}
}
