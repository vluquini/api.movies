package com.spring.api.movies.entities;

import com.spring.api.movies.dtos.MovieDto;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "movie")
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String sinopse;
	@Enumerated(value = EnumType.STRING)
	private Categories categories;
	
	public Movie(MovieDto moviesDto) {
		super();
		this.id = moviesDto.id();
		this.nome = moviesDto.nome();
		this.sinopse = moviesDto.sinopse();
		this.categories = moviesDto.categories();
		
	}
	public Movie(Long id, String nome, String sinopse, Categories categories) {
		super();
		this.id = id;
		this.nome = nome;
		this.sinopse = sinopse;
		this.categories = categories;
	}

	public Movie() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}
	
	
	

}
