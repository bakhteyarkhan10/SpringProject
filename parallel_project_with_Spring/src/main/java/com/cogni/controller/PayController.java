package com.cogni.controller;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cogni.model.Account;
import com.cogni.service.WalletService;

@RestController
@RequestMapping(value = "/accounts")
public class  PayController {
	@Autowired
	private WalletService  service;
	
	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addAccount(@RequestBody   Account acc) {
		System.out.println(acc);
		service.createAccount(acc, acc.getNumber());

		return new ResponseEntity<String>(acc+ "is created ", HttpStatus.CREATED);

	}


	@RequestMapping(value = "/Balance/{st}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String>readbalance(@PathVariable("st") String st) {
		
 
		Double bal=service.showBalance( st);

		return new ResponseEntity<String>("Balance "+bal, HttpStatus.CREATED);

	}

	@RequestMapping(value = "/Deposited/{bal}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deposit(@PathVariable("bal") Double bal,@RequestBody  Account acc) {
		System.out.println(acc);
		service.deposit(acc, acc.getNumber(),bal);

		return new ResponseEntity<String>(acc+ "is  updated ", HttpStatus.CREATED);

	}

	@RequestMapping(value = "/Withdraw/{bal}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> withdraw(@PathVariable("bal") Double bal,@RequestBody  Account acc) {
		System.out.println(acc);
		service.withdraw (acc, acc.getNumber(),bal);

		return new ResponseEntity<String>(acc+ "is updated ", HttpStatus.CREATED);

	}
	
	
	@RequestMapping(value = "/{mob1}/{mob2}/{bal}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> withdraw(@PathVariable("mob1") String mob1,@PathVariable("mob2") String mob2,@PathVariable("bal") Double bal,@RequestBody  Account acc) {
		System.out.println(acc);
		service.fundTransfer(acc, mob1,mob2,bal);

		return new ResponseEntity<String>(bal+ " is transferred  ", HttpStatus.CREATED);

	}
	
	
	@RequestMapping(value = "/{mob1}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<String> withdraw(@PathVariable("mob1") String mob1 ) {
 
		return service.printTransaction(mob1);
	}
	
	
	

}
