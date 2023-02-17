package com.example.demo.service;

import org.springframework.ui.Model;

import com.example.demo.entity.BoardDTO;

public interface BoardService {

	void createBoard(BoardDTO dto);

	void findAll(Model model);

}
