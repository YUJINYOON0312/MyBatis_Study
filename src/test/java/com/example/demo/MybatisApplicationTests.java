package com.example.demo;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.BoardDTO;
import com.example.demo.mapper.BoardMapper;

@SpringBootTest
class MybatisApplicationTests {
	
	@Autowired
	BoardMapper mapper;
	
	//@Test
	void 더미() {
		IntStream.rangeClosed(1, 10000).forEach(i->{
			mapper.save(BoardDTO.builder()
					.title("테스트"+i).content("con"+i).writer("name"+(i%9+1))
					.build()
					);
		});
	}

}
