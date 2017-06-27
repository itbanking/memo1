package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.domain.Memo;
import com.example.util.Pagination;

@Mapper
public interface MemoMapper {
	
	/*
	 *	select 
	 */
	
	@Select("select count(*) from memo")
	int memoCount();
	
	@Select("select memo_mno_seq.nextval from dual")
	int memoSeq();
	
	@Select("select * from memo")
	List<Memo> selectAll();
	
	@Select({
		"select * ",
		"from memo",
		"offset #{firstItem} - 1 rows",
		"fetch next #{itemsPerPage} rows only"
	})
	List<Memo> selectPageMemo(Pagination pagination);
	
	@Select("select * from memo where mno = #{mno}")
	Memo selectMno(int mno);
	
	/*
	 * 	insert
	 */
	int insert(Memo memo);
	
	/*
	 * 	update
	 */
	int update(Memo memo);
	
	/*
	 * 	delete
	 */
	@Delete("delete from memo where mno=#{mno}")
	int delete(int mno);
}
