package com.tola.dev.phoneShope.service.impl;

import java.util.List;
import java.util.Map;

//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tola.dev.phoneShope.entity.Brands;
import com.tola.dev.phoneShope.exception.ResourceNotFoundException;
import com.tola.dev.phoneShope.repository.BrandRepository;
import com.tola.dev.phoneShope.service.BrandService;
import com.tola.dev.phoneShope.service.util.PageUtil;
import com.tola.dev.phoneShope.specification.BrandSpecification;
import com.tola.dev.phoneShope.specification.BrandsFilter;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {
	@Autowired
	private final BrandRepository brandRepository;

	@Override
	public Brands CreateBrand(Brands brands) {
		// TODO Auto-generated method stub
		/*
		 * Brands brand2 = brandRepository.save(brands); return brand2;
		 */
		return brandRepository.save(brands);
	}

	@Override
	public Brands getById(Integer id) {
		// TODO Auto-generated method stub
		/*
		 * Optional<Brands> brandOptional = brandRepository.findById(id);
		 * if(brandOptional.isPresent()) { return brandOptional.get(); } throw new
		 * HttpClientErrorException(HttpStatus.NOT_FOUND,
		 * "Brand with id = "+id+"not found");
		 */

		return brandRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Brands", id));
		/*
		 * .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND,String.
		 * format("brand with id = %d not found", id))); .orElseThrow(() -> new
		 * HttpClientErrorException(HttpStatus.NOT_FOUND,String.
		 * format("brand with id = %d not found", id)));
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

		return brandRepository.findByNameContainingIgnoreCase(name);
	}

	@Override
	public List<Brands> getBrands(Map<String, String> params) {
		BrandsFilter brandsFilter = new BrandsFilter();
		if(params.containsKey(("name"))) {
			String name = params.get("name");
			brandsFilter.setName(name);
		}
		
		if(params.containsKey(("id"))){
			String id= params.get("id");
			brandsFilter.setId(Integer.parseInt(id));
		}
		BrandSpecification brandSpecification = new BrandSpecification(brandsFilter);
		return brandRepository.findAll(brandSpecification);
	}
	
	
	@Override
	public Page<Brands> getBrand(Map<String, String> params) {
		BrandsFilter brandsFilter = new BrandsFilter();
		if(params.containsKey(("name"))) {
			String name = params.get("name");
			brandsFilter.setName(name);
		}
		
		if(params.containsKey(("id"))){
			String id= params.get("id");
			brandsFilter.setId(Integer.parseInt(id));
		}
		
		int pageLimit = PageUtil.DEFAULT_PAGE_LIMIT;
		
		if(params.containsKey(PageUtil.PAGE_LIMIT)) {
			pageLimit = Integer.parseInt(params.get((PageUtil.PAGE_LIMIT)));
		}
		int pageNumber = PageUtil.DEFAULT_PAGE_NUMBER;
		
		if(params.containsKey(PageUtil.PAGE_NUMBER)) {
			pageNumber = Integer.parseInt(params.get(PageUtil.PAGE_NUMBER));
		}
		
		BrandSpecification brandSpecification = new BrandSpecification(brandsFilter);
		Pageable pageable = PageUtil.getPageable(pageNumber, pageLimit);
		Page<Brands> page = brandRepository.findAll(brandSpecification , pageable);
		return page;
	}


}
