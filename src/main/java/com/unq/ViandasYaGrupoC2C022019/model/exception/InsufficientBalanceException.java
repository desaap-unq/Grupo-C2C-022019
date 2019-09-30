package com.unq.ViandasYaGrupoC2C022019.model.exception;

public class InsufficientBalanceException extends RuntimeException {

	private double amount;

	public InsufficientBalanceException(double amount) {
		this.amount = amount;
	}

	@Override
	public String getMessage() {
		return "Insufficient balance for the amount ["+ this.amount +"]";
	}

}
