package com.unq.ViandasYaGrupoC2C022019.util.loader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.unq.ViandasYaGrupoC2C022019.model.Client;
import com.unq.ViandasYaGrupoC2C022019.model.VirtualWallet;
import com.unq.ViandasYaGrupoC2C022019.persistence.ClientRepository;
import com.unq.ViandasYaGrupoC2C022019.persistence.VirtualWalletRepository;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private ClientRepository crepository;
	private VirtualWalletRepository vwrepository;

	@Autowired
	public DatabaseLoader(ClientRepository crepository, 
						  VirtualWalletRepository vwrepository,
						  BusinessRepository brepository) {
		this.crepository = crepository;
		this.vwrepository = vwrepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		// Clean-up DB tables
		crepository.deleteAllInBatch();
		vwrepository.deleteAllInBatch();
		
		//=============================================
		
		VirtualWallet vw = new VirtualWallet();
		Client client01 = new Client("Pomelo", "Rock", "prock@user.com", 15156205, "LaFuente 2123", "Soldati");
		client01.setWallet(vw);
		
		this.vwrepository.save(vw);
		this.crepository.save(client01);
	}

}
