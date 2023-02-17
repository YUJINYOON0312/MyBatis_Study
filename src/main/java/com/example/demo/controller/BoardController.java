package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.BoardDTO;
import com.example.demo.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	BoardService service;
	
	@PostMapping("/board/new")
	public String board(BoardDTO dto) {
		service.createBoard(dto);
		return "board/list";
	}
	
	@GetMapping("/boards")
	public String boards(Model model) {
		service.findAll(model);
		return "board/list";
	}
}
