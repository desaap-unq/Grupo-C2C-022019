package com.unq.ViandasYaGrupoC2C022019.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class menuTest {
    @Test
    public void createMenu__AMenu() {
        
        List<MenuCategory> menuCategoryList = new ArrayList<>();
        menuCategoryList.add(MenuCategory.HAMBURGUESAS);
        
        Menu menu = new Menu("Hamburgesa", "Hamburguesa de carne con tomate y queso",
                        menuCategoryList ,40D, LocalDate.now(),LocalDate.now(),
                        LocalTime.of(0,20), LocalTime.of(0,20), 50D, 1, 50D, 3,120D,100);
	
	       assertTrue(menu.getCategory().contains(MenuCategory.HAMBURGUESAS));
	       assertTrue(menu.getDeliveryCost() == 40D);
	       assertEquals(menu.getMaximumAmountSalesPerDay(),100);
    }
}
