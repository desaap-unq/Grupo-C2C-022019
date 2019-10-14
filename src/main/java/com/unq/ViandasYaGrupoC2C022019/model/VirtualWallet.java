package com.unq.ViandasYaGrupoC2C022019.model;

import com.unq.ViandasYaGrupoC2C022019.model.exception.InsufficientBalanceException;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.springframework.data.annotation.Id;

@Entity
public class VirtualWallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @javax.persistence.Id
    private Long id;
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

    public void setBalance(double balance) {
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
        if ((balance - amount) < 0) {
            throw new InsufficientBalanceException(amount);
        }
        this.balance -= amount;
    }

    public double removeCash(double amount) {
        if ((balance - amount) < 0) {
            throw new InsufficientBalanceException(amount);
        }
        double cash = this.balance;
        this.balance = 0;
        return cash;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    

}
