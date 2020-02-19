package com.cpg.movies.dto;

import java.util.Date;

public class Movie {
	private Integer movieId;
	private String movieName;
	private String movieGenre;
	private String movieDirector;
	private Integer movieLength;
	private String[] languages;
	private Date movieReleaseDate;
	
	public Movie() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Movie(Integer movieId, String movieName, String movieGenre,
			String movieDirector, Integer movieLength, Date movieReleaseDate) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieGenre = movieGenre;
		this.movieDirector = movieDirector;
		this.movieLength = movieLength;
		this.languages=new String[] {"Hindi","Telugu","Tamil"};
		this.movieReleaseDate = movieReleaseDate;
	}



	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	public String getMovieDirector() {
		return movieDirector;
	}

	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}

	public Integer getMovieLength() {
		return movieLength;
	}

	public void setMovieLength(Integer movieLength) {
		this.movieLength = movieLength;
	}

	public String[] getLanguages() {
		return languages;
	}

	public void setLanguages(String[] languages) {
		this.languages = languages;
	}

	public Date getMovieReleaseDate() {
		return movieReleaseDate;
	}

	public void setMovieReleaseDate(Date movieReleaseDate) {
		this.movieReleaseDate = movieReleaseDate;
	}
	
	

}
