package com.cpg.movies.util;

import java.util.HashMap;

import com.cpg.movies.dto.Theatre;

public class TheatreRepository {
	public static HashMap<Integer,Theatre> TheatreData=new HashMap<Integer,Theatre>();
	static private Integer theatreId=2000;
	static
	{
		Theatre theatre=addTheatre(new Theatre(theatreId,"Sridevi Multiplex","Warangal","Sandeep","9573028680"));	
		theatre=addTheatre(new Theatre(theatreId,"Bhavani","Kazipet","Sandeep","7888575854"));
		theatre=addTheatre(new Theatre(theatreId,"Murali","Jammikunta","Thirupathi","9603162015"));
		theatre=addTheatre(new Theatre(theatreId,"HariHara","Jammikunta","Thirupathi","9866740680"));
		theatre=addTheatre(new Theatre(theatreId,"Annapurna","Jammikunta","Thirupathi","9866767445"));
		theatre=addTheatre(new Theatre(theatreId,"Ashoka","Wrangal","sandeep","9573028680"));
	}
	public TheatreRepository() {
		// TODO Auto-generated constructor stub
	}
	public static Theatre addTheatre(Theatre t)
	{
		TheatreData.put(theatreId,t);
		if(TheatreData.get(theatreId)==null)
		{
			System.out.println(theatreId);
			System.out.println(t.getTheatreName()+" Theatre is Not added");
			return null;
		}
		theatreId=theatreId+1;
		return TheatreData.get(theatreId-1);
		
	}
	public static  Theatre removeTheatre(Integer id)
	{
		return TheatreData.remove(id);
	}
	public static Theatre getTheatre(Integer id)
	{
		return TheatreData.get(id);
	}
	public static boolean isTheatreExist(Integer id)
	{
		System.out.println(id);
		if(TheatreData.get(id)!=null)
		{
			return true;
		}
		return false;
	}

}
