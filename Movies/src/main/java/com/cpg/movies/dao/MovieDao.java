package com.cpg.movies.dao;

import com.cpg.movies.dto.Movie;
import com.cpg.movies.util.MovieRepository;

public class MovieDao {
	public static Movie getMovie(Integer id)
	{
		return MovieRepository.MovieData.get(id);
	}

}
