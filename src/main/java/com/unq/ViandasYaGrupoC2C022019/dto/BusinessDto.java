package com.unq.ViandasYaGrupoC2C022019.dto;

public class BusinessDto {

	private String name;
	private String logo;
	private String locality;
	private String address;
	private int phone;
	private String days;
	private String description;
	private String link;
	private Long id;

	public BusinessDto() {	}
	
	public BusinessDto(String name, String logo, String description) {
		this.name = name;
		this.logo = logo;
		this.description = description;
	}
	
	public BusinessDto(Long id, String name, String logo, String locality, String address, int phone, String days, String description, String link) {
		this.id = id;
		this.name = name;
		this.logo = logo;
		this.locality = locality;
		this.address = address;
		this.phone = phone;
		this.days = days;
		this.description = description;
		this.link = link;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
