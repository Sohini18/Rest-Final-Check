package com.cognizant.moviecruiser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.dao.FavoritesDao;
import com.cognizant.moviecruiser.exception.MovieNotFoundException;
import com.cognizant.moviecruiser.model.Movie;

@Service
public class FavoritesServiceImpl implements FavoritesService {

	@Autowired
	FavoritesDao favoritesDao;

	@Override
	public void addFavoritesItem(String userId, long movieId) throws MovieNotFoundException {
		favoritesDao.addFavoritesItem(userId, movieId);
	}

	@Override
	public List<Movie> getAllFavoritesItems(String userId) {
		return favoritesDao.getAllFavoritesItems(userId);
	}

	@Override
	public void removeFavoritesItem(String userId, long movieId) throws MovieNotFoundException {
		favoritesDao.removeFavoritesItem(userId, movieId);
	}

	@Override
	public long getTotalFav(String userId) {
		return favoritesDao.getTotalFav(userId);
	}

}
