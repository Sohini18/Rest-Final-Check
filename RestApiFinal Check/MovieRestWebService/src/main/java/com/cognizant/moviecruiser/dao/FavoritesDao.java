package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.exception.MovieNotFoundException;
import com.cognizant.moviecruiser.model.Movie;

public interface FavoritesDao {
	void addFavoritesItem(String userId, long movieId) throws MovieNotFoundException;

	List<Movie> getAllFavoritesItems(String userId);

	void removeFavoritesItem(String userId, long movieId) throws MovieNotFoundException;

	long getTotalFav(String userId);
}
