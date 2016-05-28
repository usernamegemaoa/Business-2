package com.sample.app.domain;

import javax.persistence.Table;

import lombok.Data;

/**
 * 会社情報テーブルのカラムを保持するDto。会社情報Dto
 * @author miyata
 */
@Table(name = "company_info")
@Data
public class CompanyInfo {
	/**
	 * 会社名略称
	 */
	private String abbreviation;

	/**
	 * 会社情報インスタンス
	 * @param abbreviation
	 */
	public CompanyInfo(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	/**
	 * 会社名略称取得
	 * @return abbreviation
	 */
	public String getAbbreviation() {
		return abbreviation;
	}

	/**
	 * 会社名略称設定
	 * @param abbreviation
	 */
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
}