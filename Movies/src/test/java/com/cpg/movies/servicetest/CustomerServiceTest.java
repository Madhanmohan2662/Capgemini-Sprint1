package com.cpg.movies.servicetest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.cpg.movies.dto.Booking;
import com.cpg.movies.dto.Ticket;
import com.cpg.movies.service.CustomerService;

public class CustomerServiceTest {
	@Test
	public void BookMovieTicketTest()
	{
		CustomerService obj = new CustomerService();
		boolean exp = obj.bookMovieTicket(1000);
		assertEquals(false, exp);
	}
	@Test
	public void CancelMovieTicketTest()
	{
		CustomerService obj = new CustomerService();
		Ticket t=null;
		boolean exp = obj.cancelTicket(t, 10000);
		assertEquals(false, exp);
	}
	@Test
	public void ChooseCityTest()
	{
		CustomerService obj = new CustomerService();
		boolean exp = obj.chooseCity("Kazipet");
		assertEquals(true, exp);
	}
	
	

}
