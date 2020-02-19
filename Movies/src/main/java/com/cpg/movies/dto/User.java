package com.cpg.movies.dto;

import java.time.LocalDate;
import java.util.Scanner;

import com.cpg.movies.dto.Customer;
import com.cpg.movies.service.UserService;

public class User {
	private Integer userId;
	private String password;
	UserService userservice=new UserService();
	public User() {
		// TODO Auto-generated constructor stub
	}
	Scanner sc=new Scanner(System.in);
	public Customer registerNewUser()
	{
		Customer customer=new Customer();
		System.out.println("Enter customer Name : ");
		customer.setCustomerName(sc.next());
		System.out.println("Enter Date of Birth year,month and date");
		customer.setDateOfBirth(LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		System.out.println("Enter contact number");
		customer.setCustomerContact(sc.next());
		System.out.println("Enter password");
		customer.setPassword(sc.next());
		
		return  userservice.createNewUser(customer);
	}

	public boolean signout()
	{
		System.out.println("You are signed out successfully");
		return true;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
