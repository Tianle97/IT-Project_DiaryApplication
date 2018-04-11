package com.project.service;

import java.util.ArrayList;

import com.project.diary.Diary;

public interface DiaryServiceImp {

	ArrayList<Diary> showall();

	ArrayList<Diary> findByuser(String username);
	
	ArrayList<Diary> findBytitle(String title);
	
}
