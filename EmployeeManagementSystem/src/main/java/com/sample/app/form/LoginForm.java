package com.sample.app.form;

import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * ログイン画面のフォーム
 * @author miyata
 *
 */
@Data
public class LoginForm {
	/**
	 * ログインID
	 */
	@NotNull
	private String loginId;
	
	/**
	 * パスワード
	 */
	@NotNull
	private String password;

	
	/**
	 * ログインID取得
	 * @return loginId
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * パスワード取得
	 * @return loginId
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