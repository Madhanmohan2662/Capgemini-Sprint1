package com.cpg.movies.dao;

import com.cpg.movies.dto.Screen;
import com.cpg.movies.util.ScreenRepository;

public class ScreenDao {
	public ScreenDao() {
		// TODO Auto-generated constructor stub
	}

	public Screen getScreen(Integer screenId)
	{
		return ScreenRepository.getScreenData().get(screenId);
	}
	
	public boolean AddScreen(Screen screen)
	{
		Screen s=ScreenRepository.ScreenData.put(ScreenRepository.getKey(), screen);
		if(screen==null)
		{
			return false;
		}
			System.out.println(screen.getScreenName() +" Successfully Added");
			ScreenRepository.keyIncrement();
			return true;
	}

}
