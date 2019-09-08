package com.unq.ViandasYaGrupoC2C022019.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClientTest {

	@Test
	public void testCreateAccount_APerson() {
		Client client = new Client("Gabriel", "Guzman", "gabriel.guzman@alu.unq.edu.ar", 1515151515, "Banfield", "Laprida 458");
		
		assertEquals(client.getName(), "Gabriel");
		assertEquals(client.getBalance(), 0.0, 0.000);
	}
	
	@Test
	public void testCreateAccount_APersonBuilderWithName() {
		Client aClient = ClientBuilder.aClient()
						.withName("Gabriel")
						.build();
		
		assertEquals(aClient.getName(), "Gabriel");
	}
	
	@Test
	public void testCreateAccountWithCash_APersonBuilder() {
		Client aClient = ClientBuilder.aClient()
						.build();
		
		aClient.chargeCash(15.2);

		assertEquals(aClient.getBalance(), 15.2, 0.000);
	}
	
	@Test
	public void voidCreateAccount_ABusiness() {
		Business aBusiness = BusinessBuilder.aBusiness()
							.withName("McDonalds")
							.build();
		
		Account business = new Account(aBusiness.getName(), aBusiness.getLogo(), aBusiness.getLocality(), aBusiness.getPhone(), true);
		
		assertEquals(business.getName(), "McDonalds");
		assertTrue(business.isBusiness());
		assertFalse(business.isClient());
	}

}
