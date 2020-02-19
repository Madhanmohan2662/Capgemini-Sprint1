package com.cpg.movies.util;

import java.util.HashMap;

import com.cpg.movies.dto.Screen;
import com.cpg.movies.util.ScreenRepository;

public class ScreenRepository {
private static int key=1000;
	
	public static HashMap<Integer,Screen> ScreenData=new HashMap<Integer,Screen>();
	static
	{
		ScreenData.put(1001, new Screen(1001,2001,"SCREEN 1",null,5,5));
		ScreenData.put(1002, new Screen(1002,2001,"SCREEN 2",null,5,5));
		ScreenData.put(1003, new Screen(1003,2001,"SCREEN 1",null,5,5));
		ScreenData.put(1004, new Screen(1004,2002,"SCREEN 2",null,8,8));
		ScreenData.put(1005, new Screen(1005,2002,"SCREEN 3",null,5,5));
	}
	public ScreenRepository() {
		// TODO Auto-generated constructor stub
	}
	public static int getKey() {
		return key;
	}
	public static void setKey(int key) {
		ScreenRepository.key = key;
	}
	public static HashMap<Integer, Screen> getScreenData() {
		return ScreenData;
	}
	public static void keyIncrement()
	{
		key++;
	}

}
