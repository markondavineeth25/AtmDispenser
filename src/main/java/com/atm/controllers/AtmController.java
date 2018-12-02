package com.atm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atm.models.Cash;

@RestController
@ControllerAdvice
@RequestMapping("/atm")
public class AtmController {
	
	@Autowired
	CashMaster cashMaster;

	@GetMapping
	public Cash balance() {
		return cashMaster.balance();
	}
	
	@SuppressWarnings("static-access")
	@RequestMapping(value="/{amt}", method=RequestMethod.GET)
	public ResponseEntity<Object> withdraw(@PathVariable int amt) {
		
		System.out.println(amt);
		
		if (amt>500) {
			return new ResponseEntity<Object>("Amount greater than 500, not accepted",
					HttpStatus.FORBIDDEN);
		}
		
		if (amt<50 && amt%20!=0) {
			return new ResponseEntity<Object>("Incorrect amt entered",
					HttpStatus.FORBIDDEN);
		}
		
		if (amt%10!=0) {
			return new ResponseEntity<Object>("Incorrect amt entered",
					HttpStatus.FORBIDDEN);
		}
		
		return new ResponseEntity<Object>(cashMaster.withdraw(amt),
				HttpStatus.OK);
		
	}
}
