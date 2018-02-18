package com.example.model;

import java.util.List;

public class Person {

	private String id;
	private String name;
	private List<String> bookids;
	
	Person(String id, String name, List<String> bookids){
		this.id=id;
		this.name = name;
		this.bookids =bookids;
		
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List getBookids() {
		return bookids;
	}
}
