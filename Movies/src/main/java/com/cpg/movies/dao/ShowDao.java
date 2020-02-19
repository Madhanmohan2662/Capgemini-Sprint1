package com.cpg.movies.dao;

import com.cpg.movies.dto.Show;
import com.cpg.movies.util.ShowRepository;

public class ShowDao {
	public ShowDao() {
		// TODO Auto-generated constructor stub
	}
	public Show getSeatMap(Integer showId)
	{
		return ShowRepository.ShowData.get(showId);
		
	}

}
