package com.tola.dev.phoneShope.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tola.dev.phoneShope.entity.Models;
import com.tola.dev.phoneShope.exception.ResourceNotFoundException;
import com.tola.dev.phoneShope.repository.ModelRepository;
import com.tola.dev.phoneShope.service.ModelService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService {

	private final ModelRepository modelRepository;

	@Override
	public Models createModels(Models models) {

		return modelRepository.save(models);

	}

	@Override
	public List<Models> getByBrandId(Long brandId) {
		return modelRepository.findByBrandsId(brandId);
	}

	@Override
	public Models getById(Long id) {
		return modelRepository.
				findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Models", id));
	}

}
