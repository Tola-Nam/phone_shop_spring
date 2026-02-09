package com.tola.dev.phoneShope.service.impl;

import org.springframework.stereotype.Service;

import com.tola.dev.phoneShope.entity.Color;
import com.tola.dev.phoneShope.exception.ResourceNotFoundException;
import com.tola.dev.phoneShope.repository.ColorRepository;
import com.tola.dev.phoneShope.service.ColorService;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class ColorServiceImpl implements ColorService {

	private final ColorRepository colorRepository;
	@Override
	public Color createColor(Color color) {
		return colorRepository.save(color);
	}

	@Override
	public Color getById(Long id) {
		return colorRepository
				.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("color", id));
	}



}
