package com.example.board1.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.example.board1.entity.Board;

@Mapper
public interface BoardMapper {
	
	public int write(Board board);

	public ArrayList<Board> boardList();
}


