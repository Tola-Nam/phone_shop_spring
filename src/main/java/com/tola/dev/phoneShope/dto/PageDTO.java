package com.tola.dev.phoneShope.dto;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.jaxb.SpringDataJaxb.PageDto;

import lombok.Data;

@Data
public class PageDTO {
	private List<?> list;
	private PaginationDTO paginationDTO;
	
	@SuppressWarnings("static-access")
	public PageDTO( Page<?> page) {
		this.list = page.getContent();
		this.paginationDTO = paginationDTO.builder()
				.empty(page.isEmpty()).first(page.isFirst())
				.last(page.isLast())
				.pageSize(page.getPageable().getPageSize())
				.pageNumber(page.getPageable().getPageNumber()+1)
				.totalPages(page.getTotalPages())
				.totalElements(page.getTotalElements())
				.numberOfElements(page.getNumberOfElements())
				.build();
	}
}
