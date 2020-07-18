package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cognizant.moviecruiser.exception.MovieNotFoundException;
import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.MovieService;

@Repository
public class FavoritesDaoImpl implements FavoritesDao {

	private static Map<String, Favorites> favItems = new HashMap<>();

	@Autowired
	MovieService movieService;

	@Override
	public void addFavoritesItem(String userId, long movieId) throws MovieNotFoundException {
		Movie movie = movieService.getMovie(movieId);
		if (favItems.containsKey(userId)) {
			Favorites userFav = favItems.get(userId);
			List<Movie> list = userFav.getMovieList();
			list.add(movie);
			userFav.setMovieList(list);
			userFav.setNoOfFavorites(userFav.getNoOfFavorites() + 1);
			favItems.put(userId, userFav);
		} else {
			Favorites newFav = new Favorites();
			List<Movie> list = new ArrayList<>();
			list.add(movie);
			newFav.setMovieList(list);
			newFav.setNoOfFavorites(1);
			favItems.put(userId, newFav);
		}
	}

	@Override
	public List<Movie> getAllFavoritesItems(String userId) {
		Favorites fav = favItems.get(userId);
		return fav.getMovieList();
	}

	@Override
	public void removeFavoritesItem(String userId, long movieId) throws MovieNotFoundException {
		Movie movie = movieService.getMovie(movieId);
		Favorites fav = favItems.get(userId);
		List<Movie> movieList = fav.getMovieList();
		movieList.remove(movie);
		fav.setNoOfFavorites(fav.getNoOfFavorites() - 1);
		favItems.put(userId, fav);
	}

	@Override
	public long getTotalFav(String userId) {
		Favorites fav = favItems.get(userId);
		return fav.getNoOfFavorites();
	}

}
