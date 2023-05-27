package com.spring.api.movies.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.spring.api.movies.dtos.MovieDto;
import com.spring.api.movies.services.MovieService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/movies")
public class MovieController {
	@Autowired
	private MovieService movieService;
	
	
	@GetMapping
	public List<MovieDto> listar(@RequestParam(required = false) String nome){
		return movieService.listar(nome);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<MovieDto> cadastrar(@RequestBody MovieDto moviesDto, UriComponentsBuilder uriBuilder){
		return movieService.cadastrar(moviesDto, uriBuilder);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<MovieDto> atualizar(@PathVariable Long id, @RequestBody MovieDto moviesDto){
		return movieService.atualizar(id, moviesDto);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<MovieDto> apagar(@PathVariable Long id){
		return movieService.apagar(id);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MovieDto> buscarPorId(@PathVariable Long id){
		return movieService.buscarPorId(id);
	}
		
}
