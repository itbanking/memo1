package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Memo;
import com.example.service.MemoSearchService;
import com.example.service.MemoUnregisterService;

@Controller
@RequestMapping("/memo")
public class MemoUnregisterController {

	@Autowired
	MemoSearchService memoSearchService;
	
	@Autowired
	MemoUnregisterService memoUnregisterService;
	
	@GetMapping("/unregister/{mno}")
	public String unregister(Memo memo, @PathVariable int mno){
		
		Memo memolist = memoSearchService.selectMno(mno);
		memo.setTitle(memolist.getTitle());
		memo.setMcontent(memolist.getMcontent());
		memo.setMdate(memolist.getMdate());
		memo.setMembername(memolist.getMembername());
		
		return "memo/unregisterForm";
	}
	@PostMapping("/unregister/{mno}")
	public String unregister(@PathVariable int mno){
		memoUnregisterService.unregister(mno);
		
		return "redirect:/memo/unregisterSuccess/" + mno;
	}
	
	@GetMapping("/unregisterSuccess/{mno}")
	public String unregisterSuccess(@PathVariable int mno, Model model){
	
		model.addAttribute("mno", mno);
		return "memo/unregisterSuccess";
	}
	
}
