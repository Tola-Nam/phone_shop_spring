package com.tola.dev.phoneShope.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tola.dev.phoneShope.dto.ProductDTO;
import com.tola.dev.phoneShope.entity.Products;
import com.tola.dev.phoneShope.service.ColorService;
import com.tola.dev.phoneShope.service.ModelService;

@Mapper(componentModel = "spring", uses = { ModelService.class, ColorService.class })
public interface ProductMapper {

	@Mapping(target = "models", source = "modelId")
	@Mapping(target = "color", source = "colorId")
	Products toProducts(ProductDTO productDTO);

}
