package com.tola.dev.phoneShope.service;

import java.util.List;

import com.tola.dev.phoneShope.entity.Brands;

public interface BrandService {
	Brands CreateBrand(Brands brands);
	Brands getById(Integer id);
	Brands updateById(Integer id , Brands brandsUpdateBrands);
	List<Brands> getBrands();
	List<Brands> getBrands(String name);
}
