package com.example.serviceTest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Memo;
import com.example.mapper.MemoMapper;
import com.example.service.MemoRegisterService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemoServiceTest {
	
	@Autowired
	MemoRegisterService memoRegisterService;

	@Test
	public void testMapper(){
		System.out.println("memoRegisterService = " + memoRegisterService);
	}
	
}
