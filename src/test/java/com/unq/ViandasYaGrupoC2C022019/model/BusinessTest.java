package com.unq.ViandasYaGrupoC2C022019.model;

import com.unq.ViandasYaGrupoC2C022019.util.BusinessBuilder;
import static org.junit.Assert.*;

import org.junit.Test;

public class BusinessTest {

	@Test
	public void testCreateAccount_ABusiness() {
		Business business = new Business("Empanadas Dorita", "logo", "Lanus", "Av San Martin 3192", "Google Use", "Empandas de todo tipo", "facebook", "no-resp@gmail.com", 151515, "10 - 18", "lunes a viernes", "1km cerca de la estacion");
	
		assertEquals(business.getName(), "Empanadas Dorita");
		assertEquals(business.getBalance(), 0.0, .3);
	}
	
	@Test
	public void testCreateAccount_ABusinessBuilderWithName() {
		Business aBusiness = BusinessBuilder.aBusiness()
							.withName("McDonalds")
							.build();
		
		assertEquals(aBusiness.getName(), "McDonalds");
	}
	
	@Test
	public void testSale_CheckBalance_ABusinessBuilder() {
		Business aBusiness = BusinessBuilder.aBusiness()
							.build();
		
		// example - sale menu
		aBusiness.sale(99.85);
		
		assertEquals(aBusiness.getBalance(), 99.85, .3);
	}
	
	@Test
	public void testSale_RemoveCash_ABusinessBuilder() {
		Business aBusiness = BusinessBuilder.aBusiness()
							.build();
		
		aBusiness.sale(99.85);
		aBusiness.removeAllCash();
		
		assertEquals(aBusiness.getBalance(), 0.0, .3);
	}
	
	@Test(expected = RuntimeException.class)
	public void testRemoveCash_NoBalanceInFavor() {
		Business aBusiness = BusinessBuilder.aBusiness()
				.build();
		
		aBusiness.sale(99.85);
		assertEquals(aBusiness.getBalance(), 99.85, .3);

		aBusiness.removeCash(100);
		
	}

}
