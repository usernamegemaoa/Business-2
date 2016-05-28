package com.sample.app.enums;

/**
 * ステータスの列挙型
 * @author miyata
 */
public enum Status {
	/**
	 * 0:在籍　1:退職　2:入社待ち　3:入社キャンセル
	 */
	ENROLLMENT(0, "在籍"), RETIREMENT(1, "退職"), JOINED_WAIT(2, "入社待ち"), JOINED_CANCELLATION(3, "入社キャンセル");
	
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
	private Status(int code, String name) {
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