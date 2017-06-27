package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.example.domain.Memo;
import com.example.mapper.MemoMapper;

@Service
public class MemoModifyService {

	@Autowired
	MemoMapper memoMapper;
	
	public void modify(Memo memo, BindingResult errors){
		
		if(!errors.hasErrors())
			memoMapper.update(memo);
	}
}
