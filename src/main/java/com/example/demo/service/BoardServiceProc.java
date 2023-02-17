package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.demo.entity.BoardDTO;
import com.example.demo.entity.BoardsearchDTO;
import com.example.demo.mapper.BoardMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j //얜뭐야
@Service
public class BoardServiceProc implements BoardService{

	@Autowired
	private BoardMapper mapper;
	
	@Override
	public void createBoard(BoardDTO dto) {
		System.out.println(mapper);
		log.info(">>>>>>>>>>>>"+mapper);
		mapper.save(dto);
	}


	@Override
	public void findAll(BoardsearchDTO dto, Model model) {
		model.addAttribute("list", mapper.findAll(dto));
		
	}


}
