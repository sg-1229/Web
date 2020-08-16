package com.example.demo.dao;
//インターフェース
//実装クラスができることを書く

import java.util.List;

import com.example.demo.entity.Inquiry;

public interface InquiryDao {
	
	//一件のデータの挿入
	void insertInquiry(Inquiry inquiry);
	
	//すべてのinquiryテーブルのデータをListとして返す
	//java.utilのListを使う
	List<Inquiry> getAll();
	
	int updateInquiry(Inquiry inquiry);
}
