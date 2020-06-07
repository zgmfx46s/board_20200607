package com.example.board1.repository;

import java.util.ArrayList;

import com.example.board1.entity.Board;

public interface BoardRepository {
	
	public int write(Board board);
	
	public ArrayList<Board> boardList();

}
