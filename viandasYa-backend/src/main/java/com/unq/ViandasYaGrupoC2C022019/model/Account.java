package com.unq.ViandasYaGrupoC2C022019.model;

public class Account {

	private String name;
	private String surname;
	private String email;
	private int phone;
	private String locality;
	private String address;
	private boolean client;
	
	private String logo;
	private boolean business;
	
	public Account(String name, String surname, String email, int phone, String locality, String address, boolean client) {
		// constructor Client
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
		this.locality = locality;
		this.address = address;
		this.client = client;
		// validate data
	}

	public Account(String name, String logo, String locality, int phone, boolean business) {
		// constructor Business
		this.name = name;
		this.logo = logo;
		this.locality = locality;
		this.phone = phone;
		this.business = business;
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

	public boolean isClient() {
		return client;
	}

	public void setClient(boolean client) {
		this.client = client;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public boolean isBusiness() {
		return business;
	}

	public void setBusiness(boolean business) {
		this.business = business;
	}


}
