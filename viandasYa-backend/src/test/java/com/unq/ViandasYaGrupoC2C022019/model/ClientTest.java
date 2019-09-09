package com.unq.ViandasYaGrupoC2C022019.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClientTest {

	@Test
	public void testCreateAccount_APerson() {
		Client client = new Client("Gabriel", "Guzman", "gabriel.guzman@alu.unq.edu.ar", 1515151515, "Banfield", "Laprida 458");
		
		assertEquals(client.getName(), "Gabriel");
		assertEquals(client.getBalance(), 0.0, .3);
	}
	
	@Test
	public void testCreateAccount_APersonBuilderWithName() {
		Client aClient = ClientBuilder.aClient()
						.withName("Gabriel")
						.build();
		
		assertEquals(aClient.getName(), "Gabriel");
	}
	
	@Test
	public void testChargeCash_Balance_APersonBuilder() {
		Client aClient = ClientBuilder.aClient()
						.build();
		
		aClient.chargeCash(15.2);

		assertEquals(aClient.getBalance(), 15.2, .3);
	}
	
	@Test
	public void testBalance2BuyMenu_ABusiness() {
		Client aClient = ClientBuilder.aClient()
						.build();

		aClient.chargeCash(16);
		// example - buy menu
		aClient.buyMenu(15.2);
		
		assertEquals(aClient.getBalance(), 0.8, .3);
	}

}
