package com.example.demo.service;

import org.springframework.ui.Model;

import com.example.demo.entity.BoardDTO;
import com.example.demo.entity.BoardsearchDTO;

public interface BoardService {

	void createBoard(BoardDTO dto);


	void findAll(BoardsearchDTO dto, Model model);

}
