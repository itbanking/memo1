package com.example.domain;

import java.sql.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Memo {

	private int mno;
	private String title;
	private String mcontent;
	private Date mdate;
	private String membername;

	public Memo() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		String str= null;
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			str = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return str;
	}
	/**
	 * @return the mno
	 */
	public int getMno() {
		return mno;
	}

	/**
	 * @param value the mno to set
	 */
	public Memo setMno(final int value) {
		mno = value;
		return this;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param value the title to set
	 */
	public Memo setTitle(final String value) {
		title = value;
		return this;
	}

	/**
	 * @return the mcontent
	 */
	public String getMcontent() {
		return mcontent;
	}

	/**
	 * @param value the mcontent to set
	 */
	public Memo setMcontent(final String value) {
		mcontent = value;
		return this;
	}

	/**
	 * @return the mdate
	 */
	public Date getMdate() {
		return mdate;
	}

	/**
	 * @param value the mdate to set
	 */
	public Memo setMdate(final Date value) {
		mdate = value;
		return this;
	}

	/**
	 * @return the membername
	 */
	public String getMembername() {
		return membername;
	}

	/**
	 * @param value the membername to set
	 */
	public Memo setMembername(final String value) {
		membername = value;
		return this;
	}

}
