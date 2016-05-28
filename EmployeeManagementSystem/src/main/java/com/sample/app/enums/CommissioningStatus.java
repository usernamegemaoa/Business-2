package com.sample.app.enums;

/**
 * 稼働状況の列挙型
 * @author miyata
 */
public enum CommissioningStatus {
	/**
	 * 0:未稼働　1:稼働
	 */
	NOT_RUNNING(0, "未稼働"), RUNNING(1, "稼働");

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
	 * @param code
	 * @param name
	 */
	private CommissioningStatus(int code, String name) {
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
	 */
	public String toString() {
		return name;
	}
}