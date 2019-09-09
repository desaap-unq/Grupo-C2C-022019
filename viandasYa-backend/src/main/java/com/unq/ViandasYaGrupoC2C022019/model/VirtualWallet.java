package com.unq.ViandasYaGrupoC2C022019.model;

public class VirtualWallet {

	private double balance;

	public VirtualWallet() {
		this.balance = 0;
	}
	
	public VirtualWallet(double amount) {
		this.balance = amount;
	}

	public double getBalance() {
		return this.balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void chargeCash(double amount) {
		this.balance += amount;
	}

	public double removeAllCash() {
		double cash = this.balance;
		this.balance = 0;
		return cash;
	}

	public void sale(double amount) {
		this.balance += amount;
	}

	public void buy(double amount) {
		this.balance -= amount;
	}

}
