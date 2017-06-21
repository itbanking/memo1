package com.example.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Memo;
import com.example.mapper.MemoMapper;
import com.example.service.MemoRegisterService;
import com.example.service.MemoSearchService;


@Controller
@RequestMapping("/memo")
public class MemoRegisterController {

	static Log log = LogFactory.getLog(MemoRegisterController.class);
	
	@Autowired
	MemoRegisterService memoRegisterService;
	
	@Autowired
	MemoSearchService memoSearchService;
	
	@Autowired
	MemoMapper memoMapper;
	
	@GetMapping("/register")
	public String registerForm(Memo memo){
		memo.setMno(memoMapper.memoSeq());
		log.info(memo);
		return "/memo/registerForm";
	}
	
	@PostMapping("/register")
	public String register(Memo memo, BindingResult errors){
		log.info(memo);
		if(errors.hasErrors()){
			System.out.println(errors);
			return "/memo/registerForm";
		}
		memoRegisterService.register(memo, errors);
		
		if(errors.hasErrors()){
			System.out.println(errors);
			return "/memo/registerForm";
		}
	
		return "redirect:/memo/registerSuccess/" + memo.getMno();
	}
	
	@GetMapping("/registerSuccess/{mno}")
	public String registerSuccess(@PathVariable int mno, Model model){
		Memo memo = memoSearchService.selectMno(mno);
		model.addAttribute("memo" , memo);
		return "memo/registerSuccess";
	}
			
}
