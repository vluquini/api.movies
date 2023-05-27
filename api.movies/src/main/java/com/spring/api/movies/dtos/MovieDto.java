package com.spring.api.movies.dtos;

import com.spring.api.movies.entities.Categories;

public record MovieDto(
		Long id,
		String nome,
		String sinopse,
		Categories categories
		) {
}
