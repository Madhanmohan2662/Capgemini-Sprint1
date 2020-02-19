package com.cpg.movies.dto;

import java.time.LocalDate;

import com.cpg.movies.dao.TheatreDao;
import com.cpg.movies.dto.Theatre;
import com.cpg.movies.dto.Ticket;
import com.cpg.movies.util.TicketRepository;
import com.cpg.movies.service.CustomerService;

public class Customer {
	private Integer userid;
	private String customerName;
	private String password;
	private LocalDate dateOfBirth;
	private Ticket[] myTickets;
	private String customerContact;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	public void addTicketToMyTickets(Integer id)
	{
		Ticket t=TicketRepository.getTicket(id);
		if(t==null)
		{
			System.out.println("Ticket with Id : "+id+" is not found in the Database");
			return;
		}
		if(myTickets==null)
		{
			myTickets=new Ticket[1];
			myTickets[0]=t;
			return;
		}
		Ticket[] listOfTickets=new Ticket[myTickets.length+1];
		for (int i = 0; i < myTickets.length; i++) {
			listOfTickets[i]=myTickets[i];
		}
		listOfTickets[myTickets.length]=t;
		this.myTickets=listOfTickets;
		System.out.println("Your Tickets successfully updated");
		return;
		
	}
	public boolean bookMovieTicket(Theatre theatre){
		
		CustomerService cs=new CustomerService();
		return cs.bookMovieTicket(theatre.getTheatreId());

	}
	
	public boolean cancelMovieTicket(Ticket ticket)
	{
		
		CustomerService cs=new CustomerService();
		return cs.cancelTicket(ticket, getUserid());
		
	}
	public boolean chooseCity(String city)
	{
		TheatreDao theatreaccess=new TheatreDao();
		Theatre []theatres=theatreaccess.getListOfTheatres(city);
		if(theatres!=null)
		{
			System.out.println("Available theatre's In your location are :");
			for (int i = 0; i < theatres.length; i++) {
				System.out.println(theatres[i].getTheatreName());
			}
		}
		return true;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Ticket[] getMyTickets() {
		return myTickets;
	}

	public void setMyTickets(Ticket[] myTickets) {
		this.myTickets = myTickets;
	}

	public String getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}

	public void signout() {
		// TODO Auto-generated method stub
		
	}
	


}
