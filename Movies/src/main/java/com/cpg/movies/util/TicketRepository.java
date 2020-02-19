package com.cpg.movies.util;

import java.util.HashMap;

import com.cpg.movies.dto.Booking;
import com.cpg.movies.dto.Ticket;

public class TicketRepository {
	public static HashMap<Integer,Ticket> TicketData=new HashMap<Integer,Ticket>();
	public static Integer ticketId=10000001; 
	static
	{
		Ticket t=addTicket(new Ticket(ticketId,4,new Booking(),true,"Screen 1"));
		t=addTicket(new Ticket(ticketId,3,new Booking(),true,"Screen 2"));
		t=addTicket(new Ticket(ticketId,5,new Booking(),true,"Screen 3"));
		t=addTicket(new Ticket(ticketId,6,new Booking(),true,"Screen 4"));
		t=addTicket(new Ticket(ticketId,8,new Booking(),true,"Screen 5"));
	}
	public TicketRepository() {
		
	
	}
	public static Ticket addTicket(Ticket t)
	{
		TicketData.put(ticketId, t);
		if(TicketData.get(ticketId)==null)
		{
			return null;
		}
		ticketId++;
		return TicketData.get(ticketId-1);
	}
	public static Ticket getTicket(Integer id)
	{
		return TicketData.get(id);
	}

}
