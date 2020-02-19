package com.cpg.movies.dto;

import com.cpg.movies.dto.Movie;
import com.cpg.movies.dto.Screen;
import com.cpg.movies.dto.Theatre;
import com.cpg.movies.util.TheatreRepository;

public class Theatre {
	private Integer theatreId;
	private String theatreName;
	private String theatreCity;
	private Movie[] listOfMovies;
	private Screen[] listOfScreens;
	private String managerName;
	private String managerContact;
	
	public Theatre() {
		
		Screen screen=new Screen();	
		
	}
	
	
	
	public Theatre(Integer theatreId, String theatreName, String theatreCity,
			String managerName, String managerContact) {
		super();
		this.theatreId = theatreId;
		this.theatreName = theatreName;
		this.theatreCity = theatreCity;
		this.managerName = managerName;
		this.managerContact = managerContact;
	}



	public Movie searchMovie(String movieName)
	{
		if(this.getListOfMovies()==null) return null;
		for (int i = 0; i < listOfMovies.length; i++) {
			if(listOfMovies[i].getMovieName().equals(movieName))
			{
				return listOfMovies[i];
			}
		}
		return null;
	}
	
	public Screen searchScreen(Integer screenid)
	{
		for (int i = 0; i < listOfScreens.length; i++) {
			if(listOfScreens[i].getScreenId()==screenid)
			{
				return listOfScreens[i];
			}
		}
		return null;
	}

	public Integer getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(Integer theatreId) {
		this.theatreId = theatreId;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public String getTheatreCity() {
		return theatreCity;
	}

	public void setTheatreCity(String theatreCity) {
		this.theatreCity = theatreCity;
	}

	public Movie[] getListOfMovies() {
		return listOfMovies;
	}

	public void setListOfMovies(Movie[] listOfMovies) {
		this.listOfMovies = listOfMovies;
	}

	public Screen[] getListOfScreens() {
		return listOfScreens;
	}

	public void setListOfScreens(Screen[] listOfScreens) {
		this.listOfScreens = listOfScreens;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerContact() {
		return managerContact;
	}

	public void setManagerContact(String managerContact) {
		this.managerContact = managerContact;
	}
	
	public void showTheatreDetails(Integer id)
	{
		Theatre theatre=TheatreRepository.TheatreData.get(id);
		if(theatre==null)
		{
			System.out.println("No theatre exists with given Id");
			return;
		}
		System.out.println("Theatre Id : "+theatre.getTheatreId());
		System.out.println("Theatre Name : "+theatre.getTheatreName());
		System.out.println("Theatre City : "+ theatre.getTheatreCity());	
	}
	public void showTheatreDetailsAdmin(Integer id)
	{
		Theatre theatre=TheatreRepository.TheatreData.get(id);
		if(theatre==null)
		{
			System.out.println("No theatre exists with given Id");
			return;
		}
		System.out.println("Theatre Id : "+theatre.getTheatreId());
		System.out.println("Theatre Name : "+theatre.getTheatreName());
		System.out.println("Theatre City : "+ theatre.getTheatreCity());	
	}
	
	

}
