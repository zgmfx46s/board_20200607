package com.example.board1.service;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.example.board1.dto.BoardDTO;
import com.example.board1.entity.Board;

public interface BoardService {

	public boolean write(BoardDTO board, HttpSession session);


	public ArrayList<Board> boardList();
}
