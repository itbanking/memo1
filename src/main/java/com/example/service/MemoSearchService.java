package com.example.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Memo;
import com.example.mapper.MemoMapper;
import com.example.util.Pagination;

@Service
public class MemoSearchService {

	@Autowired
	MemoMapper memoMapper;
	
	public List<Memo> ListAll(){
		
		List<Memo> list = memoMapper.selectAll();
		
		return list;
	}
	
	public Map<String, Object> selectPageMemo(int pageNo){
		Pagination pagination = new Pagination();
		pagination.setTotalItem(memoMapper.memoCount());
		pagination.setPageNo(pageNo);
		
		List<Memo> list = memoMapper.selectPageMemo(pagination);
		
		Map<String, Object> map = new HashMap<>();
		map.put("memos", list);
		map.put("pagination", pagination);
		
		return map;
	}
	
	public Memo selectMno(int mno){
		
		Memo memo = memoMapper.selectMno(mno);
		
		return memo;
	}
}
