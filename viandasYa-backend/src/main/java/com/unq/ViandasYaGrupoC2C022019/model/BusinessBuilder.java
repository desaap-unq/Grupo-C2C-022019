package com.unq.ViandasYaGrupoC2C022019.model;

public class BusinessBuilder {

	public static BusinessBuilder aBusiness() {
		return new BusinessBuilder();
	}

	private String name = "no name";
	private String logo = "no logo";
	private String locality = "no locality";
	private int phone = 151515;
	
	public Business build() {
		Business aBusiness = new Business(name, logo, locality, locality, locality, locality, locality, locality, phone, locality, locality, locality);
		return aBusiness;
	}
	
	public BusinessBuilder withName(String aName) {
		this.name = aName;
		return this;
	}

}
