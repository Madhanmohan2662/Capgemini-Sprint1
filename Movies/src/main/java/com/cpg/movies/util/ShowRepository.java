package com.cpg.movies.util;

import java.util.Date;
import java.util.HashMap;

import com.cpg.movies.dto.Movie;
import com.cpg.movies.dto.Show;
import com.cpg.movies.util.ScreenRepository;

public class ShowRepository {
	public static HashMap<Integer,Show> ShowData=new HashMap<Integer,Show>();
	static
	{
		
		ShowData.put(1001,new Show(Integer.valueOf(1001),new Date(2020, 02, 16, 9, 30),new Date(2020, 02, 16, 12, 30),"MorningShow",
				new Movie(1, "Bahubali","Drama","Rajamouli", 142, new Date(2016,7,10)),
						Integer.valueOf(1001),
						Integer.valueOf(2001)));
		ShowData.put(1002,new Show(Integer.valueOf(1002),new Date(2020, 02, 16, 13, 30),new Date(2020, 02, 16, 16, 30),"Matinee",
				new Movie(1, "Bahubali","Drama","Rajamouli", 142, new Date(2016,7,10)),
						Integer.valueOf(1001),
						Integer.valueOf(2001)));
		ScreenRepository.ScreenData.get(1001).addShow(ScreenRepository.ScreenData.get(1001).getShowList(),ShowData.get(1001) );
		ScreenRepository.ScreenData.get(1001).addShow(ScreenRepository.ScreenData.get(1001).getShowList(),ShowData.get(1002) );

	}
	public ShowRepository() {
		// TODO Auto-generated constructor stub
	}

}
