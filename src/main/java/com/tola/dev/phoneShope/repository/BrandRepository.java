package com.tola.dev.phoneShope.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tola.dev.phoneShope.entity.Brands;
import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brands, Integer>{

	List<Brands> findByNameIgnoreCase(String name);
}
