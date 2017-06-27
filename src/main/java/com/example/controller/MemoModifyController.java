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
import com.example.service.MemoModifyService;
import com.example.service.MemoSearchService;

@Controller
@RequestMapping("/memo")
public class MemoModifyController {

	static Log log = LogFactory.getLog(MemoModifyController.class);
	@Autowired
	MemoSearchService memoSearchService;
	
	@Autowired
	MemoModifyService memoModifyService;
	
	@GetMapping("/modify/{mno}")
	public String Modify(Memo memo, @PathVariable int mno, Model model){
		
		Memo memolist = memoSearchService.selectMno(mno);
		memo.setTitle(memolist.getTitle());
		memo.setMdate(memolist.getMdate());
		memo.setMcontent(memolist.getMcontent());
		memo.setMembername(memolist.getMembername());
		
		model.addAttribute("memo", memo);
		
		return "memo/modifyForm";
	}
	
	@PostMapping("/modify")
	public String Modify(Memo memo, BindingResult errors){
	
		
		if(errors.hasErrors()){
			System.out.println(errors);
			return "memo/modifyForm";
		}
		memoModifyService.modify(memo, errors);
		if(errors.hasErrors()){
			System.out.println(errors);
			return "memo/modifyForm";
		}
		log.info(memo);
		return "redirect:/memo/modifySuccess/" + memo.getMno();
	}
	
	@GetMapping("/modifySuccess/{mno}")
	public String modifySuccess(@PathVariable int mno, Model model){
		
		Memo memo = memoSearchService.selectMno(mno);
		model.addAttribute("memo", memo);
		return "memo/modifySuccess";
	}
	
}
