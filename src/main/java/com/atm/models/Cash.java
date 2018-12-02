package com.atm.models;

public class Cash {

	private int totalCash;
	private int balanceCash;
	
	private int notes500;
	private int notes50;
	private int notes20;
	
	public Cash() { 
		totalCash = 10000;
		balanceCash = 10000;
	}

	public Cash(int notes500, int notes50, int notes20) {
		super();
		this.notes500 = notes500;
		this.notes50 = notes50;
		this.notes20 = notes20;
		totalCash = notes500*500 + notes50*50 + notes20*20;
		balanceCash = notes500*500 + notes50*50 + notes20*20;
	}

	public int getTotalCash() {
		return totalCash;
	}

	public void setTotalCash(int totalCash) {
		this.totalCash = totalCash;
	}

	public int getBalanceCash() {
		return balanceCash;
	}

	public void setBalanceCash(int balanceCash) {
		this.balanceCash = balanceCash;
	}

	public int getNotes500() {
		return notes500;
	}

	public void setNotes500(int notes500) {
		this.notes500 = notes500;
	}

	public int getNotes50() {
		return notes50;
	}

	public void setNotes50(int notes50) {
		this.notes50 = notes50;
	}

	public int getNotes20() {
		return notes20;
	}

	public void setNotes20(int notes20) {
		this.notes20 = notes20;
	}
	
	
	
}
