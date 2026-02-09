package com.tola.dev.phoneShope.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.jaxb.SpringDataJaxb.PageDto;
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
import com.tola.dev.phoneShope.dto.ModelDTO;
import com.tola.dev.phoneShope.dto.PageDTO;
import com.tola.dev.phoneShope.entity.Brands;
import com.tola.dev.phoneShope.entity.Models;
import com.tola.dev.phoneShope.mapper.BrandMapper;
import com.tola.dev.phoneShope.mapper.ModelMapper;
import com.tola.dev.phoneShope.service.BrandService;
import com.tola.dev.phoneShope.service.ModelService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/brands")
public class BrandConroller {

	private final BrandService brandService;
	private final ModelService modelService;
	private final ModelMapper modelMapper;

	@PostMapping
	public ResponseEntity<?> create(@RequestBody BrandDTO brandDTO) {
//		Brands brands = Mapper.toBrand(brandDTO);
		Brands brands = BrandMapper.iNSANCE.toBrands(brandDTO);

		brands = brandService.CreateBrand(brands);
		/*
		 * do not use DTO Data Transfer Object response all the we insert return
		 * ResponseEntity.ok(brands);
		 * 
		 * use this DTO Data Transfer Object we can set response
		 */
		return ResponseEntity.ok(BrandMapper.iNSANCE.toBrandDTO(brands));
	}

	@GetMapping("{id}")
	public ResponseEntity<?> getOneBrand(@PathVariable("id") Long brandId) {
		Brands brands = brandService.getById(brandId);
		return ResponseEntity.ok(BrandMapper.iNSANCE.toBrandDTO(brands));
	}

	@PutMapping("{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long brandId, @RequestBody BrandDTO brandDTO) {
		Brands brands = BrandMapper.iNSANCE.toBrands(brandDTO);
		Brands updateBrands = brandService.updateById(brandId, brands);
		return ResponseEntity.ok(BrandMapper.iNSANCE.toBrandDTO(updateBrands));
	}

	@GetMapping
	public ResponseEntity<?> getBrands() {

		return ResponseEntity.ok(brandService.getBrands());
	}

	@GetMapping("filter")
	public ResponseEntity<?> getbrands(@RequestParam("name") String nameString) {
		List<BrandDTO> list = brandService.getBrands(nameString).stream()
				.map(brnads -> BrandMapper.iNSANCE.toBrandDTO(brnads)).collect(Collectors.toList());
		return ResponseEntity.ok(list);
	}

	@GetMapping("search")
	public ResponseEntity<?> getBrands(@RequestParam Map<String, String> params) {
		List<BrandDTO> list = brandService.getBrands(params).stream()
				.map(brands -> BrandMapper.iNSANCE.toBrandDTO(brands)).collect(Collectors.toList());
		return ResponseEntity.ok(list);
	}

//	@GetMapping
//	public ResponseEntity<?> getBrand(@RequestParam Map<String, String> params){
//		Page<Brands> page = brandService.getBrand(params);
//		
//		return ResponseEntity.ok(page);
//	}

	@GetMapping("/page")
	public ResponseEntity<?> getBrand(@RequestParam(required = false) Map<String, String> params) {
		Page<Brands> page = brandService.getBrand(params);
		PageDTO pageDTO = new PageDTO(page);
		return ResponseEntity.ok(pageDTO);
	}

	@GetMapping("{id}/models")
	public ResponseEntity<?> getModelByBrand(@PathVariable("id") Long brandId) {
		List<Models> brands = modelService.getByBrandId(brandId);
//		List<ModelDTO> list = brands.stream().map(model -> modelMapper.tModelDTO(model)).toList();
		List<ModelDTO> list = brands
				.stream()
//				method reference
				.map(modelMapper::tModelDTO).toList();
		return ResponseEntity.ok(list);
	}
}
