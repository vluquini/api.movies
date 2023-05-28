package com.spring.api.movies.services;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.spring.api.movies.dtos.MovieDto;
import com.spring.api.movies.entities.Movie;
import com.spring.api.movies.repositories.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	public List<MovieDto> converteListaMovies(List<Movie> listaMovies){
		return listaMovies.stream()
				.map(movie -> new MovieDto(
						movie.getId(),
						movie.getNome(),
						movie.getSinopse(),
						movie.getCategories()))
				.collect(Collectors.toList());
	}
	
	public List<MovieDto> listar(String nome){
		if(nome != null && (!nome.equalsIgnoreCase(""))) {
			return this.converteListaMovies(this.movieRepository.findByNomeContaining(nome));
		} // retorna todos os filmes se nenhum filme for especificado na url
		return this.converteListaMovies(this.movieRepository.findAll());
	}
	/*
	 * UriComponentsBuilder auxilia na criação de uma URI. Uma URI é o endereço
	 * e identificador que irá ser criado logo após a criação de um registro no banco.
	 * Ou seja, ao se criar um novo registro, um novo endereço será criado para ele também, que
	 * poderá ser acessado por ".../movies/{id}".
	 */
	public ResponseEntity<MovieDto> cadastrar(MovieDto movieDto, UriComponentsBuilder uriBuilder){
		// aqui é criado uma nova instância de filme
		Movie movie = new Movie(movieDto);
		// aqui é passado como parâmetro o id (gerado automaticamente) de filme para a uri
		URI uri = uriBuilder.path("/movies/{id}").buildAndExpand(movie.getId()).toUri();
		movieRepository.save(movie);
		
		return ResponseEntity.created(uri).body(new MovieDto(
				movie.getId(),
				movie.getNome(),
				movie.getSinopse(),
				movie.getCategories()));
	}
	
	public ResponseEntity<MovieDto> atualizar(Long id, MovieDto movieDto){
		Optional<Movie> optional = this.movieRepository.findById(id);
		
		if(optional.isPresent()) {
			Movie movie = optional.get();
			movie.setId(movieDto.id());
			movie.setNome(movieDto.nome());
			movie.setSinopse(movieDto.sinopse());
			movie.setCategories(movieDto.categories());
			this.movieRepository.save(movie);
			return new ResponseEntity<MovieDto>(new MovieDto(
					movie.getId(),
					movie.getNome(),
					movie.getSinopse(),
					movie.getCategories()),
					HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<MovieDto> apagar(Long id){
		Optional<Movie> optional = this.movieRepository.findById(id);
		
		if(optional.isPresent()) {
			Movie movie = optional.get();
			ResponseEntity<MovieDto> response = new ResponseEntity<MovieDto>(new MovieDto(
					movie.getId(),
					movie.getNome(),
					movie.getSinopse(),
					movie.getCategories()),
					HttpStatus.OK);
			this.movieRepository.deleteById(id);
			return response;
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<MovieDto> buscarPorId(Long id){
		Optional<Movie> optional = this.movieRepository.findById(id);
		
		if(optional.isPresent()) {
			Movie movie = optional.get();
			return new ResponseEntity<MovieDto>(new MovieDto(
					movie.getId(),
					movie.getNome(),
					movie.getSinopse(),
					movie.getCategories()),
					HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
