package com.atm.controllers;

import org.springframework.stereotype.Repository;

import com.atm.models.Cash;

@Repository
public class CashMaster {

	private static Cash baseCash = new Cash();
	
	static {
		baseCash = new Cash(2, 100, 300); 
	}
	
	public static Cash balance() {
		return baseCash;
	}
	
	public static Cash withdraw(int amt) {
		System.out.println(" --- with draw logic --- ");
		
		System.out.println("By ::: " + amt/500 + " - " + amt/50 + " - " + amt/20);
		System.out.println("Mod ::: " + amt%500 + " - " + amt%50 + " - " + amt%20);
		
		int notes500 = amt/500;
		int balance = amt%500;
		
		int notes50 = balance/50;
		balance = balance%50;
		
		if (balance==10 || balance==30) {
			notes50--;
			balance=balance+50;
		}
		
		int notes20 = balance/20;
		
		baseCash.setNotes500(notes500);
		baseCash.setNotes50(notes50);
		baseCash.setNotes20(notes20);
		
		amt = baseCash.getBalanceCash() - amt;
		baseCash.setBalanceCash(amt);
		
		return baseCash;
	}
}
