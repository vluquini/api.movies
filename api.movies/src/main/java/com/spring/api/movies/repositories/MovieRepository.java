package com.spring.api.movies.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.api.movies.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{
	
	List<Movie> findByNomeContaining(String nome);
	
}
