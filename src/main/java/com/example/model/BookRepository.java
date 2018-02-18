package com.example.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BookRepository {

	public List<Book> findAll() {
	
		//
		List<Book> bookList = new ArrayList<Book>();
		
		bookList.add(new Book("book-id-1","Mockingjay"));
		bookList.add(new Book("book-id-2","Malazan"));
		bookList.add(new Book("book-id-3","Effective Java"));
		bookList.add(new Book("book-id-4","Evolution of Species"));
		bookList.add(new Book("book-id-5","Bible"));
		bookList.add(new Book("book-id-6","Understanding Cryptography"));
		bookList.add(new Book("book-id-7","Harry potter"));
		bookList.add(new Book("book-id-8","50 shades of Grey"));
		bookList.add(new Book("book-id-9","Twilight"));
		return bookList;
	}

}
