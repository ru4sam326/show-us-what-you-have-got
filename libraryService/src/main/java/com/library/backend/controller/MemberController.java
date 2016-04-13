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
import org.springframework.web.bind.annotation.ResponseBody;

import com.library.backend.model.BookRequestWrapper;
import com.library.backend.model.Member;
import com.library.backend.model.PendingRequest;
import com.library.backend.model.ReservedBook;
import com.library.backend.service.BookService;
import com.library.backend.service.MemberService;

@Controller
@RequestMapping("/v1/member")
public class MemberController {

	@Autowired 
	private BookService bookService;
	
	@Autowired 
	private MemberService memberService;
	
	@RequestMapping(value="raiseBookRequest", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String raiseBookRequest(@RequestBody BookRequestWrapper bookRequestWrapper) {
		String returnResult;
		try{
			bookService.raiseBookRequest(bookRequestWrapper.getBook(),bookRequestWrapper.getMember());
			returnResult = "SUCCESS";
		}catch(Exception excp){
			returnResult = "FAILURE" + excp.getStackTrace();
		}
		return returnResult;
	}
	
	@RequestMapping(value="withdrawBookRequest", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String withdrawBookRequest(@RequestBody BookRequestWrapper bookRequestWrapper) {
		String returnResult;
		try{
			bookService.withdrawBookRequest(bookRequestWrapper.getBook(),bookRequestWrapper.getMember());
			returnResult = "SUCCESS";
		}catch(Exception excp){
			returnResult = "FAILURE" + excp.getStackTrace();
		}
		return returnResult;
	}
	
	@RequestMapping(value="approveBookRequest", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String approveBookRequest(@RequestBody BookRequestWrapper bookRequestWrapper) {
		String returnResult;
		try{
			if(bookRequestWrapper.getMember().isAdmin()){
			bookService.approveBookRequest(bookRequestWrapper.getBook(),bookRequestWrapper.getMember());
			returnResult = "SUCCESS";
			}
			else
				returnResult = "FAILURE: As the member => " + bookRequestWrapper.getMember().getName() + "is not a librarian";
		}catch(Exception excp){
			returnResult = "FAILURE" + excp.getStackTrace();
		}
		return returnResult;
	}
	
	@RequestMapping(value="getPendingRequestsByUser", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<PendingRequest>> getPendingRequestsForSpecifiedUser(@RequestBody Member member) throws ParseException{
		List<PendingRequest> pendingRequests = memberService.getPendingRequestsForSpecifiedUser(member);
		return new ResponseEntity<List<PendingRequest>>(pendingRequests, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="getAllPendingRequests", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<PendingRequest>> getAllPendingRequests() throws ParseException{
		List<PendingRequest> pendingRequests = memberService.getPendingRequestsForAll();
		return new ResponseEntity<List<PendingRequest>>(pendingRequests, HttpStatus.OK);
	}
	
	@RequestMapping(value="getReservedBooksByUser", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<ReservedBook>> getReservedBooksByUser(@RequestBody Member member) throws ParseException{
		List<ReservedBook> reservedBooks = memberService.getReservedBooksByUser(member);
		return new ResponseEntity<List<ReservedBook>>(reservedBooks, HttpStatus.OK);
	}
}
