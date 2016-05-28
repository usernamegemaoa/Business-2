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

import com.sample.app.domain.LoginInfo;
import com.sample.app.form.LoginForm;
import com.sample.app.service.LoginService;

/**
 * ログイン処理を行うController。ログインController
 * @author miyata
 */
@Controller
@RequestMapping("/login")
public class LoginController {
	
	/**
	 * ログインService宣言
	 */
	@Autowired
	LoginService service = new LoginService();
	
	/**
	 * ログイン初期処理
	 * @param model
	 * @return Login.html
	 */
	@RequestMapping(method = RequestMethod.GET)
    public String login(Model model) {
		/*
		 * ログインFormを設定
		 */
		model.addAttribute("loginForm", new LoginForm());
		
		/*
		 * Login.htmlに遷移
		 */
        return "Login";
    }
	
	/**
	 * ログインボタン押下時の処理
	 * @param model
	 * @param session
	 * @param loginId
	 * @param password
	 * @param form
	 * @param result
	 * @return ログイン失敗⇒Login.html　
	 *         ログイン成功⇒/list
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String post(Model model, 
			HttpSession session,
			@RequestParam(value = "loginId", required = false) String loginId, 
			@RequestParam(value = "password", required = false) String password,
			@Validated LoginForm form, 
			BindingResult result) {
		/*
		 * ログインServiceからフォームから受け取った値を元にログイン情報取得
		 */
		LoginInfo login = null;
		try {
			login = service.find(loginId, password).get(0);
		} catch(IndexOutOfBoundsException ex) {			
		}
		/*
		 * ログイン失敗時はエラーメッセージを設定
		 * その後、Login.htmlに遷移
		 */
		if(result.hasErrors() || login == null){
			model.addAttribute("message", "ログイン失敗");
			return "Login";
		}
		
		/*
		 * セッションスコープにログインID設定
		 */
		session.setAttribute("login", login.getLoginId());

		/*
		 * 社員一覧Controllerにリダイレクト
		 */
		return "redirect:/list";
	}
}