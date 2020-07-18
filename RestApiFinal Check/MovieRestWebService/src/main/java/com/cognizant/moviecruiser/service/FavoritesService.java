package com.cognizant.moviecruiser.service;

import java.util.List;

import com.cognizant.moviecruiser.exception.MovieNotFoundException;
import com.cognizant.moviecruiser.model.Movie;

public interface FavoritesService {
	void addFavoritesItem(String userId, long movieId) throws MovieNotFoundException;

	List<Movie> getAllFavoritesItems(String userId);

	void removeFavoritesItem(String userId, long movieId) throws MovieNotFoundException;
	
	long getTotalFav(String userId);
}
