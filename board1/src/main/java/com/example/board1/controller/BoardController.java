package com.example.board1.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.board1.dto.BoardDTO;
import com.example.board1.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardService service;
	
	@GetMapping("/write")
	public ModelAndView writePage(ModelAndView mv, HttpSession session) {
		
		if(session.getAttribute("user_id") == null) {
			
			mv.setViewName("error");
		}else {
			
			mv.setViewName("write");
		}
		
		return mv;
	}

	@PostMapping("/write")
	public ModelAndView doWrite(ModelAndView mv, BoardDTO board, HttpSession session) {
		
		boolean writeResult = service.write(board, session);
		
		if(writeResult) {
			mv.setViewName("redirect:/");
			
		} else {
			mv.setViewName("error");
		}
		return mv;
	}
	
}
