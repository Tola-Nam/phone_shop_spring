package com.tola.dev.phoneShope.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tola.dev.phoneShope.entity.Models;

public interface ModelRepository extends JpaRepository<Models, Long>{

	List<Models> findByBrandsId(Long brandId);
}
