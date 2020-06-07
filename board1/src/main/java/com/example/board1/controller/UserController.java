package com.example.board1.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.board1.dto.User;
import com.example.board1.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	public static final String ERROR_MSG = "다시치라";
	public static final String SUCCESS_MSG = "회원가입ㅇㅋ";
	
	@Autowired
	UserService service;
	
	@GetMapping("/login")
	public ModelAndView loginPage(ModelAndView mv) {
		
		mv.setViewName("login");
		
		return mv;
	}
	@PostMapping("/login")
	public ModelAndView doLogin(ModelAndView mv, User user, HttpSession session) {

	boolean loginResult = service.login(user);
	if(loginResult) {
		
		session.setAttribute("user_id", user.getUser_id());
		mv.setViewName("index");
		
	}else {
		
		mv.setViewName("login");
		mv.addObject("errorMsg", ERROR_MSG);
		
	}
	return mv;
	}
	
	@GetMapping("/signIn")
	public ModelAndView signInPage(ModelAndView mv) {
		mv.setViewName("signIn");
		return mv;
	}
	
	@PostMapping("/signIn")
	public ModelAndView doSignIn(ModelAndView mv, User user) {
	
		boolean signInResult = service.signIn(user);
		
		if(signInResult) {
			mv.setViewName("login");
			mv.addObject("successMsg", SUCCESS_MSG);
		}else {
			mv.setViewName("signIn");
		}
		
		return mv;
	
	}
	
	
}
