package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Inquiry;

public interface InquiryDao {
	
	void insertInquiry(Inquiry inquiry);
	
	//Listを返す
	//java.utilのListを使う
	List<Inquiry> getAll();

}
