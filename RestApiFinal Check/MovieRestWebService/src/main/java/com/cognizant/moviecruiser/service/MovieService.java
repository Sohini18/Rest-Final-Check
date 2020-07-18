package com.cognizant.moviecruiser.service;

import java.util.List;

import com.cognizant.moviecruiser.exception.MovieNotFoundException;
import com.cognizant.moviecruiser.model.Movie;

public interface MovieService {
	List<Movie> getMovieListCustomer();

	void modifyMovie(Movie movie);

	Movie getMovie(long id) throws MovieNotFoundException;
}
