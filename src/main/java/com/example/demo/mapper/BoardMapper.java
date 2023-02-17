package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.BoardDTO;
import com.example.demo.entity.BoardsearchDTO;

@Mapper
public interface BoardMapper {

	void save(BoardDTO dto);
	
	List<BoardDTO> findAll(BoardsearchDTO dto);
	
	//serviceprocess에서 jpa 는repository, 마이바티스는 BoardMapper

}
