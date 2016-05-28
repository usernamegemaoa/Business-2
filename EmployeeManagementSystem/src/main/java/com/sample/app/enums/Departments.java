package com.sample.app.enums;

/**
 * 事業部の列挙型
 * @author miyata
 */
public enum Departments {
	/**
	 * 0:開発　1:NW　2:検証　3:オフィス　4:管理営業
	 */
	DEVELOPMENT(0, "開発"), NETWORK(1, "NW"), VERFICATION(2, "検証"), OFFICE(3, "オフィス"), MANAGEMENT(4, "管理営業");

	/**
	 * コード値
	 */
	private int code;
	/**
	 * コード名
	 */
	private String name;

	/**
	 *  コード値・コード名設定
	 */
	private Departments(int code, String name) {
		this.code = code;
		this.name = name;
	}
	
	/**
	 * コード値取得
	 * @return code コード値
	 */
	public int getCode() {
		return code;
	}
	
	/**
	 * コード名取得
	 * @return name コード名
	 */
	public String toString() {
		return name;
	}
}