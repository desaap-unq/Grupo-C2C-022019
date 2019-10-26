package com.unq.ViandasYaGrupoC2C022019.util;

import com.unq.ViandasYaGrupoC2C022019.model.Business;
import com.unq.ViandasYaGrupoC2C022019.model.VirtualWallet;
import javax.persistence.EntityManager;

public class BusinessBuilder extends AbstractPersistenceBuilder<Business> {

	public static BusinessBuilder aBusiness() {
		return new BusinessBuilder();
	}

	private String name = "no name";
	private String logo = "no logo";
	private String locality = "no locality";
	private int phone = 151515;
	private VirtualWallet virtualWallet = new VirtualWallet();
        
	public Business build() {
		Business aBusiness = new Business(name, logo, locality, locality, locality, locality, locality, locality, phone, locality, locality, locality);
		aBusiness.setWallet(virtualWallet);
		return aBusiness;
	}
	
	public Business buildAndSave(EntityManager entityManager) {
		instance = build();
		return super.build(entityManager);
	}
	
	public BusinessBuilder withName(String aName) {
		this.name = aName;
		return this;
	}

    public BusinessBuilder withWallet(VirtualWallet virtualWallet) {
        this.virtualWallet = virtualWallet;
        return this;
    }

}
