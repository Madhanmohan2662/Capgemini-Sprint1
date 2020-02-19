package com.cpg.movies.ui;

import java.util.Scanner;

import com.cpg.movies.dao.TheatreDao;
import com.cpg.movies.dto.Customer;
import com.cpg.movies.dto.Theatre;
import com.cpg.movies.dto.Ticket;
import com.cpg.movies.dto.User;
import com.cpg.movies.ui.UserUi;
import com.cpg.movies.util.MovieRepository;
import com.cpg.movies.util.TheatreRepository;
import com.cpg.movies.service.CustomerService;
import com.cpg.movies.service.UserService;

public class UserUi {
	private static boolean isSignedIn=false;
	private static User userLoggedIn=null;
	public static boolean isAdmin=false;
	static UserService userservice=new UserService();
	public UserUi() {
		// TODO Auto-generated constructor stub
		
	}
	public static boolean signin(Integer userid,String password)
	{
		if(userservice.signin(userid, password))
		{
			isSignedIn=true;
		}
		return true;
	}
	public static void main(String[] args)
	{
		
		Scanner sc=new Scanner(System.in);
		CustomerService service=new CustomerService();
		
		
//		Adding Movies to the theatre
		Theatre t=TheatreRepository.TheatreData.get(2000);
		TheatreDao accessmodule=new TheatreDao();
		accessmodule.addMovie(t.getTheatreId(), MovieRepository.MovieData.get(3003));
		accessmodule.addMovie(t.getTheatreId(), MovieRepository.MovieData.get(3002));
		accessmodule.addMovie(t.getTheatreId(), MovieRepository.MovieData.get(3001));
		
//		Registering user/customer
		Customer sandeep=new Customer();
		//sandeep=sandeep.registerNewUser();
		
		System.out.println(sandeep.getCustomerName()+"   "+sandeep.getUserid());
		
//		Signin
		Integer userid=100000;
		String password="polsani";
		System.out.println(UserUi.signin(userid,password));
//		signout
		sandeep.signout();
		
//		ChooseCity
		sandeep.chooseCity("Jammikunta");
//		Adding Tickets to User
		sandeep.addTicketToMyTickets(10000001);
		sandeep.addTicketToMyTickets(10000010);
		sandeep.addTicketToMyTickets(10000003);

//Get My Tickets
		Ticket[] tickets=sandeep.getMyTickets();
		for (int i = 0; i < tickets.length; i++) {
			System.out.println(tickets[i].getTicketId());
		}
		
//		Booking Ticket
		System.out.println(sandeep.bookMovieTicket(TheatreRepository.getTheatre(2000)));
		
//  	Cancel Ticket 0 in the list
		System.out.println(sandeep.cancelMovieTicket(sandeep.getMyTickets()[1]));;
	}

}
