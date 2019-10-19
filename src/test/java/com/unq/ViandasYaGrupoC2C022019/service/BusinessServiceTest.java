package com.unq.ViandasYaGrupoC2C022019.service;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.unq.ViandasYaGrupoC2C022019.ApplicationTests;
import com.unq.ViandasYaGrupoC2C022019.model.Business;
import com.unq.ViandasYaGrupoC2C022019.model.VirtualWallet;
import com.unq.ViandasYaGrupoC2C022019.util.BusinessBuilder;
import com.unq.ViandasYaGrupoC2C022019.util.VirtualWalletBuilder;

@Transactional
public class BusinessServiceTest extends ApplicationTests {

	@Autowired
	private EntityManager entityManager;
	@Autowired
	private BusinessService service;
	
	@Test
	public void testSaveASimple_Business() {
		Business business = new Business();
		Business aBusiness = new Business();
		
		business.setName("Dorita");
		aBusiness.setName("McDonalds");
		
		// respect the order
		service.save(business);
		service.save(aBusiness);
		
		System.out.println("Id del Negocio: " + business.getId() + " " + business.getName());
		System.out.println("Id del Negocio: " + aBusiness.getId() + " " + aBusiness.getName());
		assertNotNull(business.getId()); 	// ID 1
		assertNotNull(aBusiness.getId());	// ID 2
	}
	
	@Test
	public void testBuildASimple_Business_withWallet() {
        VirtualWallet virtualWallet = VirtualWalletBuilder.aVirtualWallet()
        												  .buildAndSave(entityManager);
		Business aBusiness = BusinessBuilder.aBusiness()
											.withWallet(virtualWallet)
											.buildAndSave(entityManager);
		
		assertNotNull(aBusiness.getId());
	}
	
	
	
}
