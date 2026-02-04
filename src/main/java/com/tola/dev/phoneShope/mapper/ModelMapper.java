package com.tola.dev.phoneShope.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.tola.dev.phoneShope.dto.ModelDTO;
import com.tola.dev.phoneShope.entity.Models;
import com.tola.dev.phoneShope.service.BrandService;


@Mapper(componentModel = "spring", uses = {BrandService.class})
public interface ModelMapper {
	
	ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);
	@Mapping(target = "brands", source = "brandId")
	Models toModels(ModelDTO modelDTO);
	@Mapping(target = "brandId", source = "brands.id")
	ModelDTO tModelDTO(Models models);
//	default Brands toBrands(Integer brId) {
//		Brands brands = new Brands();
//		brands.setId(brId);
//		return brands;
//	}
}
