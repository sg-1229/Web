package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Survey;

public interface SurveyDao {
	//一件のデータ挿入
	void insertSurvey(Survey survey);
	
	//データテーブルの内容をすべて返す
	List<Survey>  getAll();
}
