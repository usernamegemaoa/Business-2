package com.sample.app.logic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 社員情報ロジック
 * @author miyata
 */
public class EmployeeLogic {
	/**
	 * 年月日をyyyy/MM/dd形式にフォーマットする
	 * @param date
	 * @return date
	 */
	public String formatDate(String date) {
		try {
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			Date d = sdf1.parse(date);

			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
			date = sdf2.format(d);
		} catch(ParseException ex) {
		} catch(NullPointerException ex) {
		}
		
		return date;
	}
	
	/**
	 * 誕生日から年齢を算出する
	 * @param birthday
	 * @return age
	 */
	public String formatAge(String birthday) {
		String age = "";
		
	    try {
			Calendar c = Calendar.getInstance();

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date formatDate = sdf.parse(birthday);
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
			
			int birth = Integer.parseInt(sdf2.format(formatDate));
			int now = Integer.parseInt(sdf2.format(c.getTime()));
			age = String.valueOf((now - birth) / 10000);
		} catch (ParseException e) {
		}
		
		return age;
	}
}
