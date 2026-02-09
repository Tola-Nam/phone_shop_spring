package com.tola.dev.phoneShope.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tola.dev.phoneShope.entity.Color;

@Repository
public interface ColorRepository extends JpaRepository<Color, Long> {

}
