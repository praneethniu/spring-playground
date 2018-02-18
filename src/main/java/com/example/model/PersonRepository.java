package com.example.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PersonRepository {

	public List<Person> findAll() {
		return Arrays.asList(new Person("person-id-1","Bob",Arrays.asList("book-id-1","book-id-2")),
	    		new Person("person-id-3","Sam",Arrays.asList("book-id-3","book-id-4")),
	    		new Person("person-id-4","Bob",new ArrayList<>()),
	    		new Person("person-id-5","Alex",Arrays.asList("book-id-1","book-id-5")),
	    		new Person("person-id-6","Marcin",Arrays.asList("book-id-1","book-id-3","book-id-5","book-id-9")));	
	
	}
}
