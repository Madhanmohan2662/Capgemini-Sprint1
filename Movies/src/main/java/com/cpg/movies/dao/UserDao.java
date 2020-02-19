package com.cpg.movies.dao;

import com.cpg.movies.dto.Customer;
import com.cpg.movies.dto.Ticket;
import  com.cpg.movies.dto.User;
import com.cpg.movies.util.TicketRepository;
import com.cpg.movies.util.UserRepository;

public class UserDao {
	public Customer addCustomer(Customer customer)
	{
		return UserRepository.AddUser(customer);
	}
	public  boolean signIn(Integer id,String password)
	{
		Customer user=UserRepository.getUser(id);
		if(user.getPassword().equals(password))
		{
			return true;
		}
		return false;
	}
	public  boolean signOut(Integer id)
	{
		return true;
	}
	public void updatemyTickets(Integer id,Integer userid)
	{
		Customer customer=(Customer) UserRepository.getUser(id);
		Ticket[] tickets=new Ticket[customer.getMyTickets().length];
		for (int i = 0; i < customer.getMyTickets().length; i++) {
			tickets[i]=TicketRepository.getTicket(customer.getMyTickets()[i].getTicketId());
		}
		customer.setMyTickets(tickets);
		UserRepository.UserData.replace(userid, customer);
	}
	public boolean cancelTicket(Integer id,Ticket t)
	{
		
		try
		{
		Customer customer= UserRepository.getUser(id);
		if(customer!=null)
		{
			for (Ticket ticket : customer.getMyTickets()) {
				if(ticket.equals(t))
				{
					ticket.setTicketStatus(false);
					TicketRepository.TicketData.replace(ticket.getTicketId(),ticket);
					System.out.println("Ticket iD: "+ticket.getTicketId()+" is successfully cancelled");
					return true;
				}
			}
		}
		}
		catch(Exception e)
		{
			System.out.println("You are probably the admin");
		}

		return false;
	}

}
