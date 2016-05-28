package com.sample.app.enums;

/**
 * 論理削除フラグの列挙型
 * @author miyata
 */
public enum IsDeleted {
	/**
	 * 0:存在　1:削除済み
	 */
	EXIST(0), DELETE(1);

	private int code;

	/**
	 * コード値設定
	 * @param code コード値
	 */
	private IsDeleted(int code) {
		this.code = code;
	}
	
	/**
	 * コード値取得
	 * @return code コード値
	 */
	public int getCode() {
		return code;
	}
}