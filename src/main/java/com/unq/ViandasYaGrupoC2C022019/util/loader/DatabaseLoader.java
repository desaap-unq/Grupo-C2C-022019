package com.unq.ViandasYaGrupoC2C022019.util.loader;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.unq.ViandasYaGrupoC2C022019.model.Client;
import com.unq.ViandasYaGrupoC2C022019.model.VirtualWallet;
import com.unq.ViandasYaGrupoC2C022019.persistence.ClientRepository;
import com.unq.ViandasYaGrupoC2C022019.util.VirtualWalletBuilder;

@Component
public class DatabaseLoader implements CommandLineRunner{

	@Autowired
	private ClientRepository crepository;
//	private EntityManager entityManager;

	@Autowired
	public DatabaseLoader(ClientRepository crepository) {
		this.crepository = crepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
//		VirtualWallet vw = VirtualWalletBuilder.aVirtualWallet().buildAndSave(entityManager);
		Client client01 = new Client("Pomelo", "Rock", "prock@user.com", 15156205, "LaFuente 2123", "Soldati");
//		client01.setWallet(vw);
		this.crepository.save(client01);
	}

}
