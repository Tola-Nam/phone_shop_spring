package com.tola.dev.phoneShope.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.module.ResolutionException;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.tola.dev.phoneShope.entity.Brands;
import com.tola.dev.phoneShope.exception.ResourceNotFoundException;
import com.tola.dev.phoneShope.repository.BrandRepository;
import com.tola.dev.phoneShope.service.impl.BrandServiceImpl;


@ExtendWith(MockitoExtension.class)
public class BrandServiceTest {
	@Mock
	private BrandRepository brandRepository;
	
	private BrandService brandService;
	@BeforeEach
	public void SetUp() {
		brandService = new BrandServiceImpl(brandRepository);
	}

//	@Test
//	public void create() {
////		given
//		Brands brands = new Brands();
//		brands.setName("Apple");
//		brands.setId(1);
////		when
//		when(brandRepository.save(any(Brands.class))).thenReturn(brands);
//		Brands brandReturn = brandService.CreateBrand(new Brands());
////		then
//
//		assertEquals(1, brandReturn.getId());
//		assertEquals("Apple", brandReturn.getName());
//
//	}
	@Test
	public void testCreate() {
//		given
		Brands brands = new Brands();
		brands.setName("Apple");
//		when
		brandService.CreateBrand(brands);
//		then
		verify(brandRepository,times(1)).save(brands);
	}
	@Test
	public void testGetByIdSuccess() {
//		given 
		Brands brands = new Brands();
		brands.setName("Apple");
		brands.setId(1);
		
//		when
		when(brandRepository.findById(1)).thenReturn(Optional.of(brands));
		Brands brandReturnBrands = brandService.getById(1);
//		then
		
		assertEquals(1, brandReturnBrands.getId());
		assertEquals("Apple", brandReturnBrands.getName());
		
	}
	@Test
	public  void testGetByIdThrow() {
		//given
		//when
		when(brandRepository.findById(2)).thenReturn(Optional.empty());
		assertThatThrownBy(()-> brandService.getById(2)).isInstanceOf(ResourceNotFoundException.class)
	    .hasMessageContaining("id = 2")
	    .hasMessageContaining("not found");
		
//		brandService.getById(2);
		
		//then
	}
}
