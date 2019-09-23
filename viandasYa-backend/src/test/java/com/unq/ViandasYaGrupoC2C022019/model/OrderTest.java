package com.unq.ViandasYaGrupoC2C022019.model;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class OrderTest {
    
    @Test
    public void createOrder_withCalificarionCero_newOrder() {
        Client aClient = new Client("Gabriel", "Guzman", "gabriel.guzman@alu.unq.edu.ar", 1515151515, 
                                    "Banfield", "Laprida 458");
	
        Business aBusiness = new Business("Empanadas Dorita", "logo", "Lanus", "Av San Martin 3192", 
                                          "Google Use", "Empandas de todo tipo", "facebook", "no-resp@gmail.com",
                                          151515, "10 - 18", "lunes a viernes", "1km cerca de la estacion");
	Menu aMenu = new Menu();
        List<Menu> menus = new ArrayList<>();
        menus.add(aMenu);
        
        Order aOrder = new Order(aClient, aBusiness, menus);     
        assertEquals(aOrder.getBusiness(), aBusiness);
	assertEquals(aOrder.getClient(), aClient);
	assertTrue(aOrder.getMenus().contains(aMenu));
	assertEquals(aOrder.getCalification(),0);
	}
}
