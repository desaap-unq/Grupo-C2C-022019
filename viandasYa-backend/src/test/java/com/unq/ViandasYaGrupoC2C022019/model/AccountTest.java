package com.unq.ViandasYaGrupoC2C022019.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AccountTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCreateAccount_APerson() {
		Account client = new Account("Gabriel", "Guzman", "gabriel.guzman@alu.unq.edu.ar", 1515151515, "Banfield", "Laprida 458", true);
		
		assertEquals(client.getName(), "Gabriel");
		assertTrue(client.isClient());
	}
	
	@Test
	public void voidCreateAccount_ABusiness() {
		// builder business
	}

}
