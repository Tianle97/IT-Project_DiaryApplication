package com.project.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.diary.Diary;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Long>{
	ArrayList<Diary> findByUsername(String username);

	ArrayList<Diary> findByTitle(String title);
}