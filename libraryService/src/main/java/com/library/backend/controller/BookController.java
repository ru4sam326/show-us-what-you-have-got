package com.library.backend.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.library.backend.model.Book;
import com.library.backend.service.BookService;

@Controller
@RequestMapping("/v1/book")
public class BookController {

	@Autowired 
	private BookService bookService;
	
	@RequestMapping(value="getBooksByAuthor", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Book>> getBooksByAuthor(@RequestParam(value = "author") String author) throws ParseException{
		List<Book> books = bookService.findBooksByAuthor(author);
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}
	
	@RequestMapping(value="getBooksByTitle", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Book>> getBooksByTitle(@RequestParam(value = "title") String title) throws ParseException{
		List<Book> books = bookService.findBooksByTitle(title);
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}
	
	@RequestMapping(value="addNewBook", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String createBookEntry(@RequestBody Book book) {
		String returnResult;
		try{
			bookService.createBookEntry(book);
			returnResult = "SUCCESS";
		}catch(Exception excp){
			returnResult = "FAILURE" + excp.getStackTrace();
		}
		return returnResult;
	}
	
	@RequestMapping(value="updateBook", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String updateBook(@RequestBody Book book) {
		String returnResult;
		try{
			bookService.updateBook(book);
			returnResult = "SUCCESS";
		}catch(Exception excp){
			returnResult = "FAILURE" + excp.getStackTrace();
		}
		return returnResult;
	}
	
	@RequestMapping(value="deleteBook", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String deleteBook(@RequestBody Book book) {
		String returnResult;
		try{
			bookService.deleteBookEntry(book);
			returnResult = "SUCCESS";
		}catch(Exception excp){
			returnResult = "FAILURE" + excp.getStackTrace();
		}
		return returnResult;
	}
	
}
