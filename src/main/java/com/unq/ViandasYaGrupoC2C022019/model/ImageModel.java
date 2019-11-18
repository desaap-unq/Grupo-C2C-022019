package com.unq.ViandasYaGrupoC2C022019.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.Id;

@Entity
public class ImageModel {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @javax.persistence.Id
	private Long id;
	private String name;
	private String type;
	@Lob
	private byte[] data;
	@OneToOne
	private Business business;
	

	public ImageModel() { }
	
	public ImageModel(String name, String type, byte[] data, Business business) {
		this.name = name;
		this.type = type;
		this.data = data;
		this.business = business;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}
}
