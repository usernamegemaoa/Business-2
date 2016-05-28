package com.sample.app.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * 社員情報テーブルのカラムを保持するDto。社員情報Dto
 * @author miyata
 */
@Entity
@Table(name = "employee_info")
@Data
public class EmployeeInfo {	
	/**
	 * 会社名略称
	 */
	private String abbreviation;
	
	/**
	 * 社員ID
	 */
	@Id
	@GeneratedValue
	private String employeeId;

	/**
	 * 氏名
	 */
	private String name;
	
	/**
	 * 氏名（ひらがな）
	 */
	private String nameHiragana;
	
	/**
	 * 誕生日
	 */
	private String birthday;
	
	/**
	 * 性別
	 */
	private String sex;	
	
	/**
	 * メールアドレス
	 */
	private String mailAddress;	
	
	/**
	 * 携帯番号
	 */
	private String telephoneNumber;	
	
	/**
	 * 会社ID
	 */
	private String companyInfoId;	
	
	/**
	 * 担当管理営業
	 */
	private String businessManager;	
	
	/**
	 * 事業部
	 */
	private String department;
	
	/**
	 * 稼働状況
	 */
	private String commissioningStatus;	
	
	/**
	 * 入社日
	 */
	private String enterDate;
	
	/**
	 * 退社日
	 */
	private String retireDate;
	
	/**
	 * ステータス
	 */
	private String status;	

	/**
	 * 社員情報インスタンス（引数なし）
	 */
	public EmployeeInfo() {
	}

	/**
	 * 社員情報インスタンス
	 * @param abbreviation
	 * @param employeeId
	 * @param department
	 * @param name
	 * @param nameHiragana
	 * @param birthday
	 * @param sex
	 * @param mailAddress
	 * @param telephoneNumber
	 * @param companyInfoId
	 * @param businessManager
	 * @param enterDate
	 * @param retireDate
	 * @param commissioningStatus
	 * @param status
	 */
	public EmployeeInfo(String abbreviation, String employeeId, String department, 
			String name, String nameHiragana, String birthday, String sex, 
			String mailAddress, String telephoneNumber, String companyInfoId, 
			String businessManager, String enterDate, String retireDate, 
			String commissioningStatus, String status) {
		this.abbreviation = abbreviation;
		this.employeeId = employeeId;
		this.department = department;
		this.name = name;
		this.nameHiragana = nameHiragana;
		this.birthday = birthday;
		this.sex = sex;
		this.mailAddress = mailAddress;
		this.telephoneNumber = telephoneNumber;
		this.companyInfoId = companyInfoId;
		this.businessManager = businessManager;
		this.enterDate = enterDate;
		this.retireDate = retireDate;
		this.commissioningStatus = commissioningStatus;
		this.status = status;
	}

	/**
	 * 会社名略称取得
	 * @return abbreviation
	 */
	public String getAbbreviation() {
		return abbreviation;
	}
	
	/**
	 * 社員ID取得
	 * @return employeeId
	 */
	public String getEmployeeId() {
		return employeeId;
	}

	/**
	 * 氏名取得
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 氏名（ひらがな）取得
	 * @return namHiragana
	 */
	public String getNameHiragana() {
		return nameHiragana;
	}
	
	/**
	 * 誕生日取得
	 * @return birthday
	 */
	public String getBirthday() {
		return birthday;
	}
	
	/**
	 * 性別取得
	 * @return sex
	 */
	public String getSex() {
		return sex;
	}
	
	/**
	 * メールアドレス取得
	 * @return mailAddress
	 */
	public String getMailAddress() {
		return mailAddress;
	}
	
	/**
	 * 携帯番号取得
	 * @return telephoneNumber
	 */
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	
	/**
	 * 会社ID取得
	 * @return companyIndoId
	 */
	public String getCompanyInfoId() {
		return companyInfoId;
	}
	
	/**
	 * 担当管理営業取得
	 * @return businessManager
	 */
	public String getBusinessManager() {
		return businessManager;
	}
	
	/**
	 * 事業部取得
	 * @return department
	 */
	public String getDepartment() {
		return department;
	}
	
	/**
	 * 稼働状況取得
	 * @return commissioningStatus
	 */
	public String getCommissioningStatus() {
		return commissioningStatus;
	}
	
	/**
	 * 入社日取得
	 * @return enterDate
	 */
	public String getEnterDate() {
		return enterDate;
	}
	
	/**
	 * 退社日取得
	 * @return retireDate
	 */
	public String getRetireDate() {
		return retireDate;
	}
	
	/**
	 * ステータス取得
	 * @return status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 会社名略称設定
	 * @param abbreviation
	 */
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	
	/**
	 * 社員ID設定
	 * @param employeeId
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	
	/**
	 * 氏名設定
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 氏名（ひらがな）設定
	 * @param nameHiragana
	 */
	public void setNameHiragana(String nameHiragana) {
		this.nameHiragana = nameHiragana;
	}
	
	/**
	 * 誕生日設定
	 * @param birthday
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	/**
	 * 性別設定
	 * @param sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	/**
	 * メールアドレス設定
	 * @param mailAddress
	 */
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	
	/**
	 * 携帯番号設定
	 * @param telephoneNumber
	 */
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	
	/**
	 * 会社ID設定
	 * @param companyInfoId
	 */
	public void setCompanyInfoId(String companyInfoId) {
		this.companyInfoId = companyInfoId;
	}
	
	/**
	 * 担当管理営業設定
	 * @param businessManager
	 */
	public void setBusinessManager(String businessManager) {
		this.businessManager = businessManager;
	}
	
	/**
	 * 事業部設定
	 * @param department
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	
	/**
	 * 稼働状況設定
	 * @param commissioningStatus
	 */
	public void setCommissioningStatus(String commissioningStatus) {
		this.commissioningStatus = commissioningStatus;
	}
	
	/**
	 * 入社日設定
	 * @param enterDate
	 */
	public void setEnterDate(String enterDate) {
		this.enterDate = enterDate;
	}
	
	/**
	 * 退社日設定
	 * @param retireDate
	 */
	public void setRetireDate(String retireDate) {
		this.retireDate = retireDate;
	}
	
	/**
	 * ステータス設定
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}