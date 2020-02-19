package com.cpg.movies.service;

import com.cpg.movies.dao.SeatDao;
import com.cpg.movies.dao.ShowDao;
import com.cpg.movies.dao.UserDao;
import com.cpg.movies.dto.BookingState;
import com.cpg.movies.dto.Customer;
import com.cpg.movies.dto.Movie;
import com.cpg.movies.dto.Screen;
import com.cpg.movies.dto.Show;
import com.cpg.movies.util.ScreenRepository;
import com.cpg.movies.util.TheatreRepository;

public class UserService {
	public UserService() {
		// TODO Auto-generated constructor stub
	}
	
	
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
	
	public void printSeatMap(Integer showId)
	{
		ShowDao showaccess=new ShowDao();
		SeatDao seataccess=new SeatDao();
		Show show=showaccess.getSeatMap(1001);
		int columns=ScreenRepository.ScreenData.get(show.getScreenId()).getColumns();
		System.out.format("%5s", 1+"  ");
		for (int i = 0; i < show.getSeats().length; i++) {
			if(seataccess.isBooked(i+1, show.getShowId()))
			{
				System.out.print("@ ");
				if((i+1)%columns==0)
				{
					System.out.format("%5s",i+1);
					System.out.println();
					if(i+2<show.getSeats().length)
					{
						System.out.format("%5s", i+2+"  ");
					}
				}
				continue;
			}
			if(seataccess.isBlocked(i+1, show.getShowId()))
			{
				System.out.print("  ");
				if((i+1)%columns==0)
				{
					System.out.format("%5s",i+1);
					System.out.println();
					if(i+2<show.getSeats().length)
					{
						System.out.format("%5s",i+2+"  ");
					}
				}
				continue;
			}
			if(seataccess.isAvailable(i+1, show.getShowId()))
			{
				System.out.print("* ");
				if((i+1)%columns==0)
				{
					System.out.format("%5s",i+1);
					System.out.println();
					if(i+2<show.getSeats().length)
					{
						System.out.format("%5s",i+2+"  ");
					}
				}
			}
			

		}
	}
	public void getShowDeatails(String s)
	{
		Screen screen=new Screen();
		Show show=screen.searchShow(s);
		if(show==null)
		{
			System.out.println("No show present with that name");
			return;
		}
		int availableSeats=0;
		for (int i = 0; i < show.getSeats().length; i++) {
			if(show.getSeats()[i].getSeatStatus()==BookingState.Available)
			{
				availableSeats++;
			}
		}
		System.out.println("Name : "+show.getShowName());
		System.out.println("Movie : "+show.getMovieName().getMovieName());
		System.out.println("Theatre : "+ TheatreRepository.TheatreData.get(show.getTheatreId()).getTheatreName());
		System.out.println("Screen Name : "+ScreenRepository.ScreenData.get(show.getScreenId()).getScreenName());
		System.out.println("Available Seats : "+availableSeats);
		System.out.println("Timings : "+show.getShowStartTime().toString() +" to "+show.getShowEndTime().toString());
		
	}
	public void printMovieDetails(Movie movie)
	{
		if(movie==null)
			{
			System.out.println("No such movie exist");
			return;
			}
		System.out.println("Name : "+movie.getMovieName());
		System.out.println("Genre : "+movie.getMovieGenre());
		System.out.println("Run Time : "+movie.getMovieLength());
		System.out.println("Director : "+movie.getMovieDirector());
		System.out.print("Available in :"+ movie.getLanguages().toString() );
		System.out.println("Release Date : "+movie.getMovieReleaseDate() );
	}
	public void AvailableMovies(Integer id)
	{
		for (int i = 0; i < TheatreRepository.TheatreData.get(id).getListOfMovies().length; i++) {
			System.out.println(TheatreRepository.TheatreData.get(id).getListOfMovies()[i]);;
		}
	}

}
