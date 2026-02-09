package com.tola.dev.phoneShope.service;

import com.tola.dev.phoneShope.entity.Color;

public interface ColorService {
	Color createColor(Color color);
	Color getById(Long id);
}
