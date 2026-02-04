package com.tola.dev.phoneShope.service.impl;

import org.springframework.stereotype.Service;

import com.tola.dev.phoneShope.entity.Models;
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

}
