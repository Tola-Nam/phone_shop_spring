package com.tola.dev.phoneShope.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.tola.dev.phoneShope.entity.Brands;

public interface BrandService {
	Brands CreateBrand(Brands brands);
	Brands getById(Long id);
	Brands updateById(Long id , Brands brandsUpdateBrands);
	List<Brands> getBrands();
	List<Brands> getBrands(String name);
	List<Brands> getBrands(Map<String, String> params);
	Page<Brands> getBrand(Map<String, String> params);
	
}
