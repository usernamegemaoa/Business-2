package com.sample.app.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sample.app.enums.CommissioningStatus;
import com.sample.app.enums.Departments;
import com.sample.app.logic.EmployeeLogic;
import com.sample.app.service.EmployeeService;

/**
 * 社員一覧に関する処理を行うController。一覧画面Controller
 * @author miyata
 */
@Controller
public class ListController {

	/**
	 * 社員情報Service宣言
	 */
	@Autowired
	EmployeeService service = new EmployeeService();
	
	/**
	 * 一覧画面初期処理
	 * @param model
	 * @param session
	 * @return セッション取得失敗⇒/login
	 *         セッション取得成功⇒List.html
	 */
	@RequestMapping(value = "/list")
    public String list(Model model,
			HttpSession session) {
		/*
		 * ログイン失敗時はログインContorollerにリダイレクト
		 */
		if(session.getAttribute("login") == null) {
			return "redirect:/login";
		}
		
		/*
		 * 社員Serviceから全社員情報を取得
		 */
    	model.addAttribute("employees", service.findAll());	//全社員情報をセット
    	model.addAttribute("logic", new EmployeeLogic());	//会社情報ロジックをセット

		/*
		 * プルダウンメニューを設定
		 */
    	model.addAttribute("departments", Departments.values());
    	model.addAttribute("commissioningStatus", CommissioningStatus.values());
		
    	/*
    	 * List.htmlに遷移
    	 */
        return "List";
    }
	
	/**
	 * ログアウトリンク押下後の処理
	 * @param session
	 * @return /login
	 */
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		/*
		 * セッションスコープを破棄
		 */
		session.invalidate();		
		/*
		 * ログインControllerにリダイレクト
		 */
        return "redirect:/login";
    }
	
	/**
	 * 削除リンク押下時の処理
	 * @param session
	 * @param empId
	 * @return /list
	 */
	@RequestMapping(value = "/delete")
    public String delete(HttpSession session,
    		@RequestParam(value = "empId", required = false) String empId) {
		/*
		 * ログイン失敗時はログインContorollerにリダイレクト
		 */
		if(session.getAttribute("login") == null) {
			return "redirect:/login";
		}
		
		/*
		 * 社員情報Serviceから社員情報削除
		 */
		service.delete(empId);
		
		/*
		 * ログインControllerにリダイレクト
		 */
		return "redirect:/list";
    }
}