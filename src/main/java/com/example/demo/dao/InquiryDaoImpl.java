package com.example.demo.dao;
import java.sql.Timestamp;
import java.util.ArrayList;
//実装クラス
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Inquiry;

//実装クラスはクラスの上に@Repositoryをつける
//データベースを操作するクラスであることをDIコンテナにわかってもらえる
@Repository 
public class InquiryDaoImpl implements InquiryDao {
	
	//データベース操作用のクラスを受け取る変数の初期化
	private final JdbcTemplate jdbcTemplate;
	
	//JdbcTemplateを読み込む
	@Autowired 
	//デフォルトコンストラクタ内で呼び出す
	//引数にDIコンテナで生成されたインスタンスが渡される
	public InquiryDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void insertInquiry(Inquiry inquiry) {
		String sql = "INSERT INTO inquiry(name, email, contents, created) VALUES(?, ?, ?, ?) ";
		jdbcTemplate.update(sql, inquiry.getName(), inquiry.getEmail(), inquiry.getContents(), inquiry.getCreated());
	}

	@Override
	public List<Inquiry> getAll() {
		String sql = "SELECT id, name, email, contents, created FROM inquiry";
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
		List<Inquiry> list = new ArrayList<Inquiry>();
		for(Map<String, Object> result : resultList) {
			Inquiry inquiry = new Inquiry();
			inquiry.setId((int)result.get("id"));
			inquiry.setName((String)result.get("name"));
			inquiry.setEmail((String)result.get("email"));
			inquiry.setContents((String)result.get("contents"));
			inquiry.setCreated(((Timestamp)result.get("created")).toLocalDateTime());
			list.add(inquiry);
		}
		return list;
	}

}
