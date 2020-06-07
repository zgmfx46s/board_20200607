package com.example.board1.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.board1.entity.Board;
import com.example.board1.service.BoardService;
 
@Controller
public class MainController {

	public static final String EMPTY_DATA = "글음슴";
	
	@Autowired
	BoardService service;
	
	@GetMapping("/")
	public ModelAndView index(ModelAndView mv) {
		
		ArrayList<Board> list = service.boardList();
		
		if(list.isEmpty()){
		}else {
		mv.addObject("boardList", list);
		}
		
		mv.setViewName("index");
		
		return  mv;
	}
}
