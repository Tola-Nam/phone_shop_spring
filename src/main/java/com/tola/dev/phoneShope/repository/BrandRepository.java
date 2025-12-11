package com.tola.dev.phoneShope.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tola.dev.phoneShope.entity.Brands;
@Repository
public interface BrandRepository extends JpaRepository<Brands, Integer>{

}
