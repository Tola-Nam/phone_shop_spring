package com.tola.dev.phoneShope.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.tola.dev.phoneShope.entity.Brands;
import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brands, Integer>, JpaSpecificationExecutor<Brands>{

	List<Brands> findByNameContainingIgnoreCase(String name);
}
