package com.sample.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sample.app.domain.CompanyInfo;
import com.sample.app.enums.IsDeleted;

/**
 * 会社情報のDB処理を行うModel。会社Service
 * @author miyata
 */
@Service
@Transactional
public class CompanyService {
	
	/**
	 * JdbcTemplate宣言
	 */
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	
	private static final RowMapper<CompanyInfo> companyRowMapper = (rs, i) -> {
		String abbreviation = rs.getString("abbreviation");
		return new CompanyInfo(abbreviation);
	};

	/**
	 * 会社情報テーブルのレコードを全て取得
	 * @return 会社情報
	 */
	public List<CompanyInfo> find() {
		/*
		 * SQL文
		 */
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT abbreviation FROM company_info WHERE is_deleted=");
		sql.append(IsDeleted.EXIST.ordinal());

		return jdbcTemplate.query(sql.toString(), companyRowMapper);
	}
}
