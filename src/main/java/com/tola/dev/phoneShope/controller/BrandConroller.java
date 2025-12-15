package com.tola.dev.phoneShope.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tola.dev.phoneShope.dto.BrandDTO;
import com.tola.dev.phoneShope.entity.Brands;
import com.tola.dev.phoneShope.mapper.BrandMapper;
import com.tola.dev.phoneShope.service.BrandService;

@RestController
@RequestMapping("brands")
public class BrandConroller {

	@Autowired
	private BrandService brandService;
	@PostMapping
	public ResponseEntity<?> create(@RequestBody BrandDTO brandDTO) {
//		Brands brands = Mapper.toBrand(brandDTO);
		Brands brands =  BrandMapper.iNSANCE.toBrands(brandDTO);
		
		brands = brandService.CreateBrand(brands);
/*
 * do not use DTO Data Transfer Object response all the we insert 
 * 	return ResponseEntity.ok(brands);
 * 
 * use this DTO Data Transfer Object we can set response 
 */
		return ResponseEntity.ok(BrandMapper.iNSANCE.toBrandDTO(brands));
	}
	@GetMapping("{id}")
	public ResponseEntity<?> getOneBrand(@PathVariable("id") Integer brandId){
		Brands brands = brandService.getById(brandId);
		return ResponseEntity.ok(BrandMapper.iNSANCE.toBrandDTO(brands));
	}
	@PutMapping("{id}")
	public ResponseEntity<?> update(@PathVariable("id") Integer brandId, @RequestBody BrandDTO brandDTO){
		Brands brands = BrandMapper.iNSANCE.toBrands(brandDTO);
		Brands updateBrands = brandService.updateById(brandId, brands);
		return ResponseEntity.ok(BrandMapper.iNSANCE.toBrandDTO(updateBrands));
	}
	
	@GetMapping
	public ResponseEntity<?> getBrands(){
		
		return ResponseEntity.ok(brandService.getBrands());
	}
	@GetMapping("filter")
	public ResponseEntity<?> getbrands(@RequestParam("name") String nameString){
		List<BrandDTO> list = brandService.getBrands(nameString)
					.stream().map(brnads -> BrandMapper.iNSANCE.toBrandDTO(brnads))
					.collect(Collectors.toList());
		return ResponseEntity.ok(list);
	}
}
