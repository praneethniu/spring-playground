package com.example.model;

public class Book {

	private String id;
	private String name;
	//private Library library;
	
	public Book(String id ,String name){
	this.id =id;
	this.name=name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
}
