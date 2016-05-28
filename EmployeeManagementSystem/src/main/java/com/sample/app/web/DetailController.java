package com.sample.app.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sample.app.domain.EmployeeInfo;
import com.sample.app.enums.CommissioningStatus;
import com.sample.app.enums.Departments;
import com.sample.app.enums.Sex;
import com.sample.app.enums.Status;
import com.sample.app.form.EmployeeForm;
import com.sample.app.logic.EmployeeLogic;
import com.sample.app.service.CompanyService;
import com.sample.app.service.EmployeeService;

/**
 * 社員情報の新規登録or更新に関する処理を行うController。詳細画面Controller
 * @author miyata
 */
@Controller
public class DetailController {
	
	/**
	 * 社員情報Service宣言
	 */
	@Autowired
	EmployeeService employeeService = new EmployeeService();
	/**
	 * 会社情報Service宣言
	 */
	@Autowired
	CompanyService companyService = new CompanyService();
	
	/**
	 * 詳細画面初期処理
	 * @param model
	 * @param session
	 * @param empId
	 * @return セッション取得失敗⇒/login
	 *         セッション取得成功⇒Detail.html
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String detail(Model model, 
    		HttpSession session,
    		@RequestParam(value = "empId", required = false) String empId) {
		/*
		 * ログイン失敗時はログインContorollerにリダイレクト
		 */
		if(session.getAttribute("login") == null) {
			return "redirect:/login";
		}
		
		/*
		 * URLパラメータから社員情報を取得
		 */
		EmployeeForm employeeForm = new EmployeeForm();
		EmployeeLogic logic = new EmployeeLogic();
		try {
			EmployeeInfo employee = employeeService.find(empId).get(0);
			employeeForm.setName(employee.getName());
			employeeForm.setNameHiragana(employee.getNameHiragana());		
			employeeForm.setBirthday(logic.formatDate(employee.getBirthday()));		
			employeeForm.setSex(employee.getSex());		
			employeeForm.setMailAddress(employee.getMailAddress());
			employeeForm.setTelephoneNumber(employee.getTelephoneNumber());
			employeeForm.setCompanyInfoId(employee.getCompanyInfoId());
			employeeForm.setBusinessManager(employee.getBusinessManager());		
			employeeForm.setDepartment(employee.getDepartment());		
			employeeForm.setCommissioningStatus(employee.getCommissioningStatus());		
			employeeForm.setEnterDate(logic.formatDate(employee.getEnterDate()));
			employeeForm.setRetireDate(logic.formatDate(employee.getRetireDate()));		
			employeeForm.setStatus(employee.getStatus());
		} catch(IndexOutOfBoundsException ex){
		}

		/*
		 * modelに値をセット
		 */
		model.addAttribute("empId", empId);
		model.addAttribute("employeeForm", employeeForm);
		model.addAttribute("companies", companyService.find());
		model.addAttribute("departments", Departments.values());
		model.addAttribute("commissioningStatus", CommissioningStatus.values());
		model.addAttribute("status", Status.values());
		model.addAttribute("sex", Sex.values());
		
		/*
		 * 詳細画面に遷移
		 */
		return "Detail";
    }
	
	/**
	 * 登録or更新ボタン押下時の処理
	 * @param model
	 * @param session
	 * @param type
	 * @param empId
	 * @param form
	 * @param result
	 * @return セッション取得失敗⇒/login
	 *         新規追加or変更失敗⇒Detail.html
	 *         新規追加or変更成功⇒/list
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.POST)
    public String post(Model model, 
    		HttpSession session,
    		@RequestParam(value = "type", required = false) String type, 
    		@RequestParam(value = "empId", required = false) String empId,
			@Validated EmployeeForm form, 
			BindingResult result) {
		/*
		 * ログイン失敗時はログインContorollerにリダイレクト
		 */
		if(session.getAttribute("login") == null) {
			return "redirect:/login";
		}
		
		/*
		 * エラーチェック
		 * エラー発生時は詳細画面に遷移
		 */
		if (result.hasErrors()) {
    		model.addAttribute("empId", empId);
            model.addAttribute("employeeForm", form);
     		model.addAttribute("companies", companyService.find());
    		model.addAttribute("departments", Departments.values());
    		model.addAttribute("commissioningStatus", CommissioningStatus.values());
    		model.addAttribute("status", Status.values());
    		model.addAttribute("sex", Sex.values());
            return "Detail";
        }

		/*
		 * 社員情報Dtoを設定
		 */
		EmployeeInfo employee = new EmployeeInfo();
		employee.setEmployeeId(empId);
		employee.setName(form.getName());
		employee.setNameHiragana(form.getNameHiragana());
		employee.setBirthday(form.getBirthday());	
		employee.setSex(form.getSex());
		employee.setMailAddress(form.getMailAddress());
		employee.setTelephoneNumber(form.getTelephoneNumber());
		employee.setCompanyInfoId(form.getCompanyInfoId());
		employee.setBusinessManager(form.getBusinessManager());
		employee.setDepartment(form.getDepartment());
		employee.setCommissioningStatus(form.getCommissioningStatus());
		employee.setEnterDate(form.getEnterDate());
		employee.setRetireDate(form.getRetireDate());
		employee.setStatus(form.getStatus());
		
		/*
		 * typeが"add"の場合は新規追加
		 */
		if(type.equals("add")) {
			employeeService.add(employee, session.getAttribute("login").toString());
		}
		/*
		 * typeが"update"の場合は更新
		 */
		if(type.equals("update")) {
			employeeService.update(employee, session.getAttribute("login").toString());
		}
		
		/*
		 * 一覧画面Controllerにリダイレクト
		 */
        return "redirect:/list";
    }
}