package com.unq.ViandasYaGrupoC2C022019.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import org.springframework.data.annotation.Id;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @javax.persistence.Id
    private Long id;
    private String name;
    private String surname;
    private String email;
    private int phone;
    private String locality; // gmaps
    private String address;  //  ""
    @OneToOne
    private VirtualWallet wallet;

    public Client(String name, String surname, String email, int phone, String locality, String address) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.locality = locality;
        this.address = address;
        this.wallet = new VirtualWallet();
    }
    
    public Client(){}
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public VirtualWallet getWallet() {
        return wallet;
    }

    public void setWallet(VirtualWallet wallet) {
        this.wallet = wallet;
    }

    public double getBalance() {
        return this.wallet.getBalance();
    }

    public void chargeCash(double amount) {
        this.wallet.chargeCash(amount);
    }

    public void buyMenu(double amount) {
        // change amount 4 Menu
        this.wallet.buy(amount);
    }

}