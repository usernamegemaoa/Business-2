package com.sample.app.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * ログイン情報テーブルのカラムを保持するDto。ログイン情報Dto
 * @author miyata
 */
@Entity
@Table(name = "login_info")
@Data
public class LoginInfo {
	/**
	 * ログインID
	 */
	@Id
	@GeneratedValue
	private String loginId;
	
	/**
	 * パスワード
	 */
	private String password;
	
	/**
	 * ログイン情報インスタンス
	 * @param loginId
	 * @param password
	 */
	public LoginInfo(String loginId, String password) {
		this.loginId = loginId;
		this.password = password;
	}

	/**
	 * ログインID取得
	 * @return loginId
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * パスワード取得
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * ログインID設定
	 * @param loginId
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	/**
	 * パスワード設定
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
