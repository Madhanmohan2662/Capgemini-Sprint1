package com.cpg.movies.dao;

import java.util.ArrayList;
import java.util.List;

import com.cpg.movies.dto.Movie;
import com.cpg.movies.dto.Screen;
import com.cpg.movies.dto.Theatre;
import com.cpg.movies.util.TheatreRepository;

public class TheatreDao {
	public Theatre addTheatre(Theatre t)
	{
		return com.cpg.movies.util.TheatreRepository.addTheatre(t);
	}
	
	public Movie[] getListOfMovies(Integer id)
	{
		return TheatreRepository.TheatreData.get(id).getListOfMovies();
	}
	public Theatre[] getListOfTheatres(String city)
	{
		List <Theatre> list=new ArrayList<Theatre>();
		for (Theatre theatre : TheatreRepository.TheatreData.values()) {
			if(theatre.getTheatreCity().equals(city))
			{
				list.add(theatre);
			}
		}		
		Theatre[] arr=new Theatre[list.size()];
		list.toArray(arr);
		return  arr;

	}
	public void addMovie(Integer theatreid,Movie movie)
	{
		
		Theatre theatre=TheatreRepository.TheatreData.get(theatreid);
		Movie[] movielist=theatre.getListOfMovies();
		if(movielist==null)
		{
			Movie[] tempMovieList= new Movie[1];
			tempMovieList[0]=movie;
			theatre.setListOfMovies(tempMovieList);
			TheatreRepository.TheatreData.replace(theatreid,theatre);
			return;
		}
		Movie[] tempMovieList= new Movie[movielist.length+1];
		for (int i = 0; i < movielist.length; i++) {
			tempMovieList[i]=movielist[i];
		}
		tempMovieList[movielist.length]=movie;
		theatre.setListOfMovies(tempMovieList);
		TheatreRepository.TheatreData.replace(theatreid,theatre );
		System.out.println("Movie added to the theatre ");
		
	}
	public void addScreen(Integer theatreid,Screen screen)
	{
		Theatre theatre=TheatreRepository.TheatreData.get(theatreid);
		Screen[] screenlist=theatre.getListOfScreens();
		
		if(screenlist==null)
		{
			Screen[] tempScreenList= new Screen[1];
			tempScreenList[0]=screen;
			theatre.setListOfScreens(tempScreenList);
			TheatreRepository.TheatreData.replace(theatreid,theatre);
			return;
		}
		Screen[] tempScreenList= new Screen[screenlist.length+1];
		for (int i = 0; i < screenlist.length; i++) {
			tempScreenList[i]=screenlist[i];
		}
		tempScreenList[screenlist.length]=screen;
		theatre.setListOfScreens(tempScreenList);
		TheatreRepository.TheatreData.replace(theatreid, theatre);
		System.out.println("Screen added to the theatre ");		
	}
	
	public boolean checkTheatre(Integer id)
	{
		if(TheatreRepository.isTheatreExist(id))
		{
			return true;
		}
		return false;
	}

}
