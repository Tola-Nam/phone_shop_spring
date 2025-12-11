package com.tola.dev.phoneShope.service.util;

import com.tola.dev.phoneShope.dto.BrandDTO;
import com.tola.dev.phoneShope.entity.Brands;

public class Mapper {

	public static Brands toBrand(BrandDTO brandDTO) {
		
		Brands brands = new Brands();
		brands.setId(brandDTO.getId());
		brands.setName(brandDTO.getName());
		
		return brands;
	}
}
