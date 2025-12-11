package com.tola.dev.phoneShope.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tola.dev.phoneShope.entity.Brands;
import com.tola.dev.phoneShope.repository.BrandRepository;
import com.tola.dev.phoneShope.service.BrandService;
@Service
public class BrandServiceImpl implements BrandService{
	@Autowired
	private BrandRepository brandRepository;

	@Override
	public Brands CreateBrand(Brands brands) {
		// TODO Auto-generated method stub
//		Brands brand2 = brandRepository.save(brands);
//		return brand2;
		return brandRepository.save(brands);
	}

}
