package com.sample.app.enums;

/**
 * 性別の列挙型
 * @author miyata
 */
public enum Sex {
	/**
	 * 0:男　1:女
	 */
	MAN(0, "男"), FEMALE(1, "女");
	
	/**
	 * コード値
	 */
	private int code;
	/**
	 * コード名
	 */
	private String name;
	
	/**
	 * コード値・コード名設定
	 * @param code コード値
	 * @param name コード名
	 */
	private Sex(int code, String name) {
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