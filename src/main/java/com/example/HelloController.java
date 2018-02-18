package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Book;
import com.example.model.BookRepository;
import com.example.model.Person;
import com.example.model.PersonRepository;

@RestController
public class HelloController {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private PersonRepository personRepository;

	@RequestMapping("/people")
	public String helloWorld(@RequestParam("books") String commaSeparatedbookNames) {

		List<String> bookNames = Arrays.asList(commaSeparatedbookNames.split(","));

		List<Book> bl = bookRepository.findAll();

		List<String> bid = bl.stream().filter(book -> bookNames.contains(book.getName())).map(book -> {
			return book.getId();
		}).collect(Collectors.toList());

		List<Person> pl = personRepository.findAll();		

		List<String> personname = pl.stream()
				            .filter(person -> person.getBookids().containsAll(bid))
				            .map( person -> {
				            	return person.getName();
				            }).collect(Collectors.toList());

		return "personNames:" + personname;

	}
}