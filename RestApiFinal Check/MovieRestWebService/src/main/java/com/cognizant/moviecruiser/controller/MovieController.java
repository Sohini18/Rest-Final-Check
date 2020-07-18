package com.cognizant.moviecruiser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.moviecruiser.exception.MovieNotFoundException;
import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	MovieService movieService;

	@GetMapping()
	public List<Movie> getMenuItemListCustomer() {
		return movieService.getMovieListCustomer();
	}

	@GetMapping("/{id}")
	public Movie getMenuItem(@PathVariable long id) throws MovieNotFoundException {
		return movieService.getMovie(id);
	}

	@PutMapping
	public void modifyMenuItem(@RequestBody Movie movie) {
		movieService.modifyMovie(movie);
	}

}
