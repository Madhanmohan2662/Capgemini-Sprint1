package com.cpg.movies.util;

import java.util.Date;
import java.util.HashMap;

import com.cpg.movies.dto.Movie;

public class MovieRepository {
	public static HashMap<Integer,Movie> MovieData=new HashMap<Integer,Movie>();
	static Integer movieid=3000;
	static
	{
		addMovie(new Movie(movieid, "Bahubali","Drama","Rajamouli", 142, new Date(2016,7,10)));
		addMovie(new Movie(movieid, "Arjun Reddy","Romantic","Sandeep Reddy Vanga", 181, new Date(2018,8,18)));
		addMovie(new Movie(movieid, "Pokiri","Crime/Suspene","Puri Jagannath", 152, new Date(2006,8,10)));
		addMovie(new Movie(movieid, "Khaleja","Comedy","Trivikram", 162, new Date(2012,10,12)));
		addMovie(new Movie(movieid, "Gabbar Singh","Crime,comedy,Action","Harish Jayaraj", 160, new Date(2014,5,9)));
		addMovie(new Movie(movieid, "Kumari 21F","Love","Sukumar Writings", 152, new Date(2012,7,10)));
	}
	
	public MovieRepository() {
		// TODO Auto-generated constructor stub
	}

	public Movie getMovieDetails(Integer movieid)
	{
		return MovieData.get(movieid);
		
	}
	public static void addMovie(Movie movie)
	{
		if(MovieData.get(movie.getMovieId())!=null)
		{
			return;
		}
		MovieData.put(movieid, movie);
		movieid++;
		 
	}

}
