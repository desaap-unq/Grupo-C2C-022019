package com.unq.ViandasYaGrupoC2C022019.model;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.Base64;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import org.springframework.core.io.ClassPathResource;
import org.springframework.data.annotation.Id;

import com.unq.ViandasYaGrupoC2C022019.dto.BusinessDto;

@Entity
public class Business implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @javax.persistence.Id
    private Long id;
    private String name;
    @Lob
    private String logo;
    private String locality;
    private int phone;
    private String address;		// gmaps
    private String location;	//  ""
    private String description;
    private String link;
    private String email;
    private String schedule;
    private String days;
    private String delivery;
    @OneToOne
    private VirtualWallet wallet;

    public Business(String name, String logo, String locality, String address, String location, 
    				String description, String link, String email, int phone, String schelude, 
    				String days, String delivery) {
        this.name = name;
        this.logo = logo;
        this.locality = locality;
        this.address = address;
        this.location = location;
        this.description = description;
        this.link = link;
        this.email = email;
        this.phone = phone;
        this.schedule = schelude;
        this.days = days;
        this.delivery = delivery;
        this.wallet = new VirtualWallet();
    }
    
    public Business(){ }
    
    public Business(BusinessDto business) {
		this.name = business.getName();
		this.logo = business.getLogo();
		this.locality = business.getLocality();
		this.address = business.getAddress();
		this.phone = business.getPhone();
		this.days = business.getDays();
		this.description = business.getDescription();
		this.link = business.getLink();
		this.wallet = new VirtualWallet();
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
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

    public VirtualWallet getWallet() {
        return wallet;
    }

    public void setWallet(VirtualWallet wallet) {
        this.wallet = wallet;
    }

    public double getBalance() {
        return this.wallet.getBalance();
    }

    public double removeAllCash() {
        return this.wallet.removeAllCash();
    }

    public void sale(double amount) {
        this.wallet.sale(amount);
    }

    public double removeCash(int amount) {
        return this.wallet.removeCash(amount);
    }

	public void decode(String logo64) {
		byte[] decodedBytes = Base64.getDecoder().decode(logo64);
		String decodedString = new String(decodedBytes);
	}
	
	public void encode() {
		File imgfile;
		String pic = "";
		try {
			imgfile = new ClassPathResource(this.logo).getFile();
			pic = Base64.getEncoder().withoutPadding().encodeToString(Files.readAllBytes(imgfile.toPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.logo = pic;
	}

}
