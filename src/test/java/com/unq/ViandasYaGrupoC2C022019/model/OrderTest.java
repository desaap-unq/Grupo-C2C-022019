package com.unq.ViandasYaGrupoC2C022019.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OrderTest {
    
    @Test
    public void createOrder_newOrder() {
        Client aClient = new Client("Gabriel", "Guzman", "gabriel.guzman@alu.unq.edu.ar", 1515151515, 
                                    "Banfield", "Laprida 458");
	
        Business aBusiness = new Business("Empanadas Dorita", "logo", "Lanus", "Av San Martin 3192", 
                                          "Google Use", "Empandas de todo tipo", "facebook", "no-resp@gmail.com",
                                          151515, "10 - 18", "lunes a viernes", "1km cerca de la estacion");
	Menu aMenu = new Menu();
        List<Menu> menus = new ArrayList<>();
        menus.add(aMenu);
        
        Order aOrder = new Order(aClient, aBusiness, menus, DispatchType.DELIVERY, LocalDate.now(),LocalTime.of(0,25));     
        
        assertEquals(aOrder.getBusiness(), aBusiness);
	assertEquals(aOrder.getClient(), aClient);
	assertTrue(aOrder.getMenus().contains(aMenu));
	assertEquals(aOrder.getState(), OrederState.PROGRESS);
	assertEquals(aOrder.getDispatchType(), DispatchType.DELIVERY);
	assertFalse(aOrder.hasQualification());
	}
    
    @Test
    public void hasQualifyOrder_withOutQualifyOrder_returnFalse() {
        Order aOrder = OrderBuilder.aOrder().build();
        assertFalse(aOrder.hasQualification());
    }
    
    @Test
    public void hasQualifyOrder_withQualifyOrder_returnTrue() {
        Order aOrder = OrderBuilder.aOrder().build();
        aOrder.setScore(5);
        assertTrue(aOrder.hasQualification());
    }
    
    @Test
    public void calculateDeliveryTime_withDispatchTypeBusiness_returnThirtyMinutes() {
        Menu aMockMenu = mock(Menu.class);
        when(aMockMenu.getAverageDeliveryTime()).thenReturn(LocalTime.of(0,15));
        
        Menu otherMockMenu = mock(Menu.class);
        when(otherMockMenu.getAverageDeliveryTime()).thenReturn(LocalTime.of(0,15));
        
        List<Menu> mockMenus = new ArrayList();
        mockMenus.add(aMockMenu);
        mockMenus.add(otherMockMenu);
        
        Order aOrder = OrderBuilder.aOrder().withMenus(mockMenus).withDispatchType(DispatchType.BUSINESS).build();
        assertEquals(aOrder.calculateDeliveryTime(),LocalTime.of(0, 30));
    }
    
    @Test
    public void calculateDeliveryTime_withDispatchTypeDelivery_returnThirtyMinutes() {
        Menu aMockMenu = mock(Menu.class);
        when(aMockMenu.getAverageDeliveryTime()).thenReturn(LocalTime.of(0,15));
        
        Menu otherMockMenu = mock(Menu.class);
        when(otherMockMenu.getAverageDeliveryTime()).thenReturn(LocalTime.of(0,15));
        
        List<Menu> mockMenus = new ArrayList();
        mockMenus.add(aMockMenu);
        mockMenus.add(otherMockMenu);
        
        Order aOrder = OrderBuilder.aOrder()
                .withMenus(mockMenus)
                .withDispatchType(DispatchType.DELIVERY)
                .withDeliveryTime(LocalTime.of(0,25))
                .build();
        assertEquals(aOrder.calculateDeliveryTime(),LocalTime.of(0, 55));
    }
}
