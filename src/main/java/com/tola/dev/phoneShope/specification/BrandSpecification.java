package com.tola.dev.phoneShope.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.tola.dev.phoneShope.entity.Brands;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Data;
@Data
public class BrandSpecification implements Specification<Brands>{

	private final BrandsFilter brandsFilter;
	List<Predicate> predicates = new ArrayList<>();
	@Override
	public Predicate toPredicate(Root<Brands> Brands, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//		if(brandsFilter.getName() !=null) {
////			Predicate name = Brands.get("name").in(brandsFilter.getName());
////			predicates.add(name);
//			Predicate name = criteriaBuilder.like(criteriaBuilder.upper(Brands.get("name")), "%" +brandsFilter.getName().toUpperCase() +"%");
//			predicates.add(name);
//		}
		if (brandsFilter.getName() != null && !brandsFilter.getName().isBlank()) {

		    Predicate namePredicate = criteriaBuilder.like(
		        criteriaBuilder.upper(Brands.get("name")),
		        "%" + brandsFilter.getName().toUpperCase() + "%"
		    );

		    predicates.add(namePredicate);
		}

		
		if(brandsFilter.getId() != null) {
			Predicate idPredicate = Brands.get("id").in(brandsFilter.getId());
			predicates.add(idPredicate);
		}
		
//		Predicate[] array = predicates.toArray(new Predicate[0]);
		Predicate[] array = predicates.toArray(Predicate[]::new);
		return criteriaBuilder.and(array);
	}

}
