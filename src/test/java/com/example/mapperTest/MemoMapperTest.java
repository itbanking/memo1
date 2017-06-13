package com.example.mapperTest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Memo;
import com.example.mapper.MemoMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemoMapperTest {
	
	@Autowired
	MemoMapper memoMapper;

	@Test
	public void testMapper(){
		System.out.println("MemoMapper = " + memoMapper);
	}
	
	@Test
	public void testMapper_02(){
		List<Memo> list = memoMapper.selectAll();
		
		for (Memo m : list)
			System.out.println(m);
	}
}
