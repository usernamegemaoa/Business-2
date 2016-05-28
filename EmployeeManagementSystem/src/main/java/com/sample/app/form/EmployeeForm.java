package com.sample.app.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 登録/詳細画面のフォーム。
 * @author miyata
 */
public class EmployeeForm {
	/**
	 * 氏名
	 */
    @NotBlank(message = "氏名が未入力です")
	private String name;
    
    /**
     * 氏名（ひらがな）
     */
    @NotBlank(message = "氏名（ひらがな）が未入力です")
	private String nameHiragana;
    
    /**
     * 生年月日
     */
    @NotBlank(message = "生年月日が未入力です")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
	private String birthday;
    
    /**
     * 性別
     */
    @NotBlank(message = "性別が未選択です")
	private String sex;	
    
    /**
     * メールアドレス
     */
    @NotBlank(message = "メールアドレスが未入力です")
    @Email
	private String mailAddress;	
    
    /**
     * 電話番号
     */
    @NotBlank(message = "電話番号が未入力です")
    @Size(max = 13)
	private String telephoneNumber;	
    
    /**
     * 会社名
     */
    @NotBlank(message = "会社名が未選択です")
	private String companyInfoId;	
    
    /**
     * 担当管理営業
     */
    @NotBlank(message = "担当管理営業が未入力です")
	private String businessManager;	
    
    /**
     * 事業部
     */
    @NotBlank(message = "事業部が未選択です")
	private String department;
    
    /**
     * 稼働状況
     */
    @NotBlank(message = "稼働状況が未選択です")
	private String commissioningStatus;	
  
    /**
     * 入社日
     */
    @NotBlank(message = "入社日が未入力です")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
	private String enterDate;
    
    /**
     * 退社日
     */
    @NotBlank(message = "退職日が未入力です")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
	private String retireDate;
    
    /**
     * ステータス
     */
    @NotBlank(message = "ステータスが未選択です")
	private String status;

    /**
     * 氏名取得
     * @return name
     */
    public String getName() {
		return name;
	}
    
    /**
     * 氏名（ひらがな）取得
     * @return nameHiragana
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
	 * @return companyInfoId
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
	 * 氏名設定
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 氏名（ひらなが）設定
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