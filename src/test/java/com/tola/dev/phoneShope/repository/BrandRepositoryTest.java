package com.tola.dev.phoneShope.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.tola.dev.phoneShope.entity.Brands;
@DataJpaTest
public class BrandRepositoryTest {
	@Autowired
	private BrandRepository brandRepository;
	@Test
	public void TestFindByNameIgnoreCase() {
	    // given
	    Brands brand = new Brands();
	    brand.setName("Apple");
	    brandRepository.save(brand);

	    // when
	    List<Brands> listBrands =
	            brandRepository.findByNameContainingIgnoreCase("Apple");

	    // then
	    assertEquals(1, listBrands.size());
	    assertEquals("Apple", listBrands.get(0).getName());
	    assertEquals(1, listBrands.get(0).getId());
	}

}
