package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Inquiry;

@Repository //データベースを操作するクラスであることをDIコンテナにわかってもらえる
public class InquiryDaoImpl implements InquiryDao {
	
	//データベース操作用のクラスを受け取る変数の初期化
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired //読み込む
	public InquiryDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void insertInquiry(Inquiry inquiry) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public List<Inquiry> getAll() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
