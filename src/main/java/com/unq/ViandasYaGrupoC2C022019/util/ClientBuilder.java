package com.unq.ViandasYaGrupoC2C022019.util;

import javax.persistence.EntityManager;

import com.unq.ViandasYaGrupoC2C022019.model.Client;
import com.unq.ViandasYaGrupoC2C022019.model.VirtualWallet;

public class ClientBuilder extends AbstractPersistenceBuilder<Client>{

    public static ClientBuilder aClient() {
        return new ClientBuilder();
    }

    private String name = "no name";
    private String surname = "no surname";
    private String email = "no email";
    private int phone = 151515;
    private String locality = "no locality";
    private String address = "no address";
	private VirtualWallet virtualWallet = new VirtualWallet();

    public Client build() {
        Client aClient = new Client(name, surname, email, phone, locality, address);
        aClient.setWallet(virtualWallet);
        return aClient;
    }

    public ClientBuilder withName(String aName) {
        this.name = aName;
        return this;
    }
    
    public ClientBuilder withWallet(VirtualWallet vw) {
		this.virtualWallet  = vw;
		return this;
	}
    
    public Client buildAndSave(EntityManager entityManager) {
    	instance = build();
    	return super.build(entityManager);
    }
    
    //withWallet
}
