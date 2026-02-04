package com.tola.dev.phoneShope.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tola.dev.phoneShope.dto.ModelDTO;
import com.tola.dev.phoneShope.entity.Models;
import com.tola.dev.phoneShope.mapper.ModelMapper;
import com.tola.dev.phoneShope.service.ModelService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/models")
public class ModelController {

	private final ModelService modelService;
	private final  ModelMapper modelMapper;

	@PostMapping
	public ResponseEntity<?> create(@RequestBody ModelDTO modelDTO) {
		Models models = modelMapper.toModels(modelDTO);
		models = modelService.createModels(models);
		return ResponseEntity.ok(modelMapper.tModelDTO(models));
	}

}
