package com.atm;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.atm.controllers.AtmController;
import com.atm.models.Cash;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AtmDispenserApplicationTests {

	@Test
	public void test320() {
		AtmController atmController = new AtmController();
		ResponseEntity<Object> initalCash = atmController.withdraw(320);
		
		Cash cash = (Cash)initalCash.getBody();
		assertEquals(0, cash.getNotes500());
		assertEquals(6, cash.getNotes50());
		assertEquals(1, cash.getNotes20());
	}

	@Test
	public void test90() {
		AtmController atmController = new AtmController();
		ResponseEntity<Object> initalCash = atmController.withdraw(90);
		
		Cash cash = (Cash)initalCash.getBody();
		assertEquals(0, cash.getNotes500());
		assertEquals(1, cash.getNotes50());
		assertEquals(2, cash.getNotes20());
	}

	@Test
	public void test130() {
		AtmController atmController = new AtmController();
		ResponseEntity<Object> initalCash = atmController.withdraw(130);
		
		Cash cash = (Cash)initalCash.getBody();
		assertEquals(0, cash.getNotes500());
		assertEquals(1, cash.getNotes50());
		assertEquals(4, cash.getNotes20());
	}

	@Test
	public void test150() {
		AtmController atmController = new AtmController();
		ResponseEntity<Object> initalCash = atmController.withdraw(150);
		
		Cash cash = (Cash)initalCash.getBody();
		assertEquals(0, cash.getNotes500());
		assertEquals(3, cash.getNotes50());
		assertEquals(0, cash.getNotes20());
	}

	@Test
	public void test80() {
		AtmController atmController = new AtmController();
		ResponseEntity<Object> initalCash = atmController.withdraw(80);
		
		Cash cash = (Cash)initalCash.getBody();
		assertEquals(0, cash.getNotes500());
		assertEquals(0, cash.getNotes50());
		assertEquals(4, cash.getNotes20());
	}

	@Test
	public void test10() {
		AtmController atmController = new AtmController();
		ResponseEntity<Object> initalCash = atmController.withdraw(10);
		
		assertEquals("Incorrect amt entered", initalCash.getBody());
	}

	@Test
	public void test95() {
		AtmController atmController = new AtmController();
		ResponseEntity<Object> initalCash = atmController.withdraw(95);
		
		assertEquals("Incorrect amt entered", initalCash.getBody());
	}

	@Test
	public void test550() {
		AtmController atmController = new AtmController();
		ResponseEntity<Object> initalCash = atmController.withdraw(550);
		
		assertEquals("Amount greater than 500, not accepted", initalCash.getBody());
	}
	
}
