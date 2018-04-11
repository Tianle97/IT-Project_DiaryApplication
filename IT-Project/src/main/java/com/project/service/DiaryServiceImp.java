package com.project.service;

import java.util.ArrayList;

import com.project.diary.Diary;
import com.project.model.User;

public interface DiaryServiceImp {

	ArrayList<Diary> showall();

	Diary findByuser(String username);
	
	ArrayList<Diary> findBytitle(String title);
	
}
