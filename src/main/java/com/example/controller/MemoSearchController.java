package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Memo;
import com.example.service.MemoSearchService;

@Controller
@RequestMapping("/memo")
public class MemoSearchController {

	@Autowired
	MemoSearchService memoSearchService;
	
	@GetMapping("/listAll")
	public String ListAll(Model model){
		
		List<Memo> list = memoSearchService.ListAll();
		model.addAttribute("memos", list);
		
		return "memo/listAll";
	}
	
}
