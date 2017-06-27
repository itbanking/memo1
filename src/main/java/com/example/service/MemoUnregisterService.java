package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapper.MemoMapper;

@Service
public class MemoUnregisterService {

	@Autowired
	MemoMapper memoMapper;
	
	public void unregister(int mno){
		memoMapper.delete(mno);
	}
}
