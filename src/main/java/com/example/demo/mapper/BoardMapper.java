package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.BoardDTO;

@Mapper
public interface BoardMapper {

	void save(BoardDTO dto);
	
	List<BoardDTO> findAll();
	
	//serviceprocess에서 jpa 는repository, 마이바티스는 BoardMapper

}
