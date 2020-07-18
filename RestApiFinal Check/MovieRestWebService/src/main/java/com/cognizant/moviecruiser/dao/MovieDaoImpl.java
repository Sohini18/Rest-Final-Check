package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.moviecruiser.exception.MovieNotFoundException;
import com.cognizant.moviecruiser.model.Movie;

@Repository
public class MovieDaoImpl implements MovieDao {

	private static List<Movie> MOVIE_LIST = new ArrayList<>();

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieDaoImpl.class);

	@SuppressWarnings({ "unchecked", "resource" })
	public MovieDaoImpl() {
		ApplicationContext apx = new ClassPathXmlApplicationContext("moviecruiser.xml");
		MOVIE_LIST = (List<Movie>) apx.getBean("movie_list");
		LOGGER.debug("Movie:{}", MOVIE_LIST);
	}

	@Override
	public List<Movie> getMovieListCustomer() {
		return MOVIE_LIST;
	}

	@Override
	public void modifyMovie(Movie movie) {
		try {
			Movie mov = getMovie(movie.getId());
			mov.setTitle(movie.getTitle());
			mov.setBoxOffice(movie.getBoxOffice());
			mov.setActive(movie.isActive());
			mov.setGenre(movie.getGenre());
			mov.setHasTeaser(movie.isHasTeaser());
		} catch (MovieNotFoundException e) {
			e.getMessage();
		}
	}

	@Override
	public Movie getMovie(long id) throws MovieNotFoundException {
		Movie m = null;
		for (Movie mi : MOVIE_LIST) {
			if (id == mi.getId()) {
				m = mi;
			}
		}
		if (m == null) {
			throw new MovieNotFoundException("Movie Not Found");
		} else {
			return m;
		}
	}

}
