package com.unq.ViandasYaGrupoC2C022019.model;

public class Business {

	private String name;
	private String logo;
	private String locality;
	private int phone;

	public Business(String name, String logo, String locality, int phone) {
		this.name = name;
		this.logo = logo;
		this.locality = locality;
		this.phone = phone;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	
}
