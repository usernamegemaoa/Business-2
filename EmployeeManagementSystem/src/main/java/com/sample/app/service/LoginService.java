package com.sample.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sample.app.domain.LoginInfo;

/**
 * ログイン情報Service
 * @author miyata
 */
@Service
@Transactional
public class LoginService {

	/**
	 * JdbcTemplate宣言
	 */
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	
	private static final RowMapper<LoginInfo> loginRowMapper = (rs, i) -> {
		String loginId = rs.getString("login_id");
		String password = rs.getString("password");
		return new LoginInfo(loginId, password);
	};

	/**
	 * ログイン情報テーブルのレコード取得
	 * @param loginId
	 * @param password
	 * @return ログイン情報
	 */
	public List<LoginInfo> find(String loginId, String password) {
		/*
		 * SQL文
		 */
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT login_id, password ");
		sql.append("FROM login_info ");
		sql.append("WHERE login_id=:login_id AND password=:password");
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("login_id", loginId)
				.addValue("password", password);

		return jdbcTemplate.query(sql.toString(), param, loginRowMapper);
	}
}
