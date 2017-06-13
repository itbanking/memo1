package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Memo;
import com.example.mapper.MemoMapper;

@Service
public class MemoSearchService {

	@Autowired
	MemoMapper memoMapper;
	
	public List<Memo> ListAll(){
		
		List<Memo> list = memoMapper.selectAll();
		
		return list;
	}
}
