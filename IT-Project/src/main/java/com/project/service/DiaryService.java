package com.project.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.diary.Diary;
import com.project.repository.DiaryRepository;
import com.project.service.DiaryServiceImp;

@Service
public class DiaryService implements DiaryServiceImp{
	@Autowired
	private DiaryRepository diaryRepository;
	
	@Override
	public ArrayList<Diary> showall(){
		return (ArrayList<Diary>) diaryRepository.findAll();
	}

	@Override
	public ArrayList<Diary> findByuser(String username) {
		return diaryRepository.findByUsername(username);
	}

	@Override
	public ArrayList<Diary> findBytitle(String title) {
		return diaryRepository.findByTitle(title);
	}
}