package com.tola.dev.phoneShope.service.impl;

import java.util.List;

//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tola.dev.phoneShope.entity.Brands;
import com.tola.dev.phoneShope.exception.ResourceNotFoundException;
import com.tola.dev.phoneShope.repository.BrandRepository;
import com.tola.dev.phoneShope.service.BrandService;
@Service
public class BrandServiceImpl implements BrandService{
	@Autowired
	private BrandRepository brandRepository;

	@Override
	public Brands CreateBrand(Brands brands) {
		// TODO Auto-generated method stub
		/*
		 * Brands brand2 = brandRepository.save(brands);
		*return brand2;
		*/
		return brandRepository.save(brands);
	}

	@Override
	public Brands getById(Integer id) {
		// TODO Auto-generated method stub
		/*
	    	Optional<Brands> brandOptional = brandRepository.findById(id);
	    *	if(brandOptional.isPresent()) {
	    *		return brandOptional.get();
	    *	}
		*	throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Brand with id = "+id+"not found");
		*/
		
		return brandRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Brands", id));
		/*
		* 	.orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND,String.format("brand with id = %d not found", id)));
		*	.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND,String.format("brand with id = %d not found", id)));
		*/

	}

	@Override
	public Brands updateById(Integer id, Brands brandsUpdateBrands) {
		// TODO Auto-generated method stub
		Brands brands = getById(id);
		brands.setName(brandsUpdateBrands.getName());
		return brandRepository.save(brands);
	}

	@Override
	public List<Brands> getBrands() {

		return brandRepository.findAll();
	}

	@Override
	public List<Brands> getBrands(String name) {
		
		return brandRepository.findByNameIgnoreCase(name);
	}

}
