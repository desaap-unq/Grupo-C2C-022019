package com.unq.ViandasYaGrupoC2C022019.service;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Repeat;
import org.springframework.transaction.annotation.Transactional;

import com.unq.ViandasYaGrupoC2C022019.ApplicationTests;
import com.unq.ViandasYaGrupoC2C022019.model.Business;
import com.unq.ViandasYaGrupoC2C022019.model.Menu;
import com.unq.ViandasYaGrupoC2C022019.model.MenuCategory;
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
	
	@Test
	public void testFindByBusinessId() {
		Business business = new Business();
		business.setName("Dorita");
		service.save(business);
		
		assertNotNull(service.findByBusinessId(business.getId()));
	}
	
	@Repeat(value = 10)
	@Test
	public void testFindByBusinessId_More_Business() {
		Business business = new Business();
		business.setName("Dorita");
		service.save(business);
		
		VirtualWallet virtualWallet = VirtualWalletBuilder.aVirtualWallet()
				  										  .buildAndSave(entityManager);
		Business aBusiness = BusinessBuilder.aBusiness()
											.withWallet(virtualWallet)
											.withName("McDonald")
											.buildAndSave(entityManager);
		
		Business dorita = service.findByBusinessId(business.getId());
		Business mcdonald = service.findByBusinessId(aBusiness.getId());
		
		assertEquals(business.getName(), dorita.getName());
		assertEquals(aBusiness.getName(), mcdonald.getName());
	}
	
	@Test
	public void testFindByCategory_Menu() {
		List<MenuCategory> menuCategoryList = new ArrayList<>();
        menuCategoryList.add(MenuCategory.HAMBURGUESAS);
        
        VirtualWallet virtualWallet = VirtualWalletBuilder.aVirtualWallet().buildAndSave(entityManager);

        Business business = BusinessBuilder.aBusiness().withWallet(virtualWallet).buildAndSave(entityManager);
        
        // builder
        Menu menu = new Menu("Hamburguesas", "Hamburguesa de carne con tomate y queso",
                menuCategoryList, 40D, LocalDate.now(), LocalDate.now(),
                LocalTime.of(0, 20), LocalTime.of(0, 20), 50D, 1, 50D, 3, 120D, 100,business);
        
        assertFalse(service.findByCategory(MenuCategory.HAMBURGUESAS.name()).isEmpty());  
	}
	
}
