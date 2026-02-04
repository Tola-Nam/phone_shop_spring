package com.tola.dev.phoneShope.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.tola.dev.phoneShope.dto.BrandDTO;
import com.tola.dev.phoneShope.entity.Brands;

@Mapper(componentModel = "spring")
//@Mapper
public interface BrandMapper {

	BrandMapper iNSANCE = Mappers.getMapper(BrandMapper.class); 
	
	Brands toBrands(BrandDTO brandDTO);
	
	BrandDTO toBrandDTO(Brands entity);
	
}
