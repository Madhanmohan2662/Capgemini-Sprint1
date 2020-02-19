package com.cpg.movies.service;

import com.cpg.movies.dao.TheatreDao;
import com.cpg.movies.dao.UserDao;
import com.cpg.movies.dto.Customer;
import com.cpg.movies.dto.Movie;
import com.cpg.movies.dto.Theatre;
import com.cpg.movies.dto.Ticket;
//import com.cpg.movies.dto.User;

public class CustomerService {

	public Customer createNewUser(Customer user)
	{
		UserDao access=new UserDao();
		return access.addCustomer(user);
	}
	
	public boolean signin(Integer id,String password)
	{
		UserDao access=new UserDao();
		return access.signIn(id, password);
	}
	public boolean bookMovieTicket(Integer id)
	{
		TheatreDao theatreaccess=new TheatreDao();
		if(theatreaccess.checkTheatre(id))
		{
			System.out.println("Available movies in the Theatre are : ");
			for (Movie movie : theatreaccess.getListOfMovies(id)) {
				System.out.println(movie.getMovieName());
			}
			System.out.println("Sorry for the inconvienience Developing work is under process..... \n and you can book movies soon....");
		}
		return false;
		
	}
	public boolean cancelTicket(Ticket t,Integer userid)
	{
		UserDao useraccess=new UserDao();
		return useraccess.cancelTicket(userid,t);
	}
	
	public boolean chooseCity(String city)
	{
		TheatreDao t=new TheatreDao();
		Theatre [] theatres=t.getListOfTheatres(city);
		if(theatres==null) return false;
		for (int i = 0; i < theatres.length; i++) {
			System.out.println(theatres[i].getTheatreName());
		}
		return true;
		
	}

}
