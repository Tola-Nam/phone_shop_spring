package com.tola.dev.phoneShope.service;

import java.util.List;

import com.tola.dev.phoneShope.entity.Models;

public interface ModelService {

	Models createModels(Models models);
	List<Models> getByBrandId(Long brandId);
	Models getById(Long id);
}
