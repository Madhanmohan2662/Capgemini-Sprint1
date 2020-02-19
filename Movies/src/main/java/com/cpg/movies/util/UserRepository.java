package com.cpg.movies.util;

import java.util.HashMap;
import java.math.BigInteger;
import java.util.HashMap;




import com.cpg.movies.dto.Customer;

public class UserRepository {
	public static HashMap<Integer,Customer> UserData=new HashMap<Integer,Customer>();
	private static Integer userIdGenerator=100000;
	public UserRepository() {
		// TODO Auto-generated constructor stub
	}
	
	public static Customer AddUser(Customer user)
	{
		UserData.put(userIdGenerator,user);
		if(UserData.get(userIdGenerator)==null)
		{
			return null;
		}
		user.setUserid(userIdGenerator);
		userIdGenerator++;
		return user;
	}
	public static Customer getUser(Integer Id)
	{
		
		return UserData.get(Id);
	}


}
