package com.unq.ViandasYaGrupoC2C022019.model;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class menuTest {
    @Test
	public void createMenu__AMenu() {
		Business business = new Business("Empanadas Dorita", "logo", "Lanus", "Av San Martin 3192", "Google Use", "Empandas de todo tipo", "facebook", "no-resp@gmail.com", 151515, "10 - 18", "lunes a viernes", "1km cerca de la estacion");
	
		assertEquals(business.getName(), "Empanadas Dorita");
		assertEquals(business.getBalance(), 0.0, .3);
	}
}