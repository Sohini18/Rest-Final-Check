package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.exception.MovieNotFoundException;
import com.cognizant.moviecruiser.model.Movie;

public interface MovieDao {
	List<Movie> getMovieListCustomer();

	void modifyMovie(Movie movie);

	Movie getMovie(long id) throws MovieNotFoundException;
}
