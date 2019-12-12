package com.unq.ViandasYaGrupoC2C022019.model;

import com.unq.ViandasYaGrupoC2C022019.util.BusinessBuilder;
import com.unq.ViandasYaGrupoC2C022019.util.MenuBuilder;
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
        Business business = BusinessBuilder.aBusiness().build();
        Menu menu = new Menu("Hamburgesa", "Hamburguesa de carne con tomate y queso",
                menuCategoryList, 40D, LocalDate.now(), LocalDate.now(),
                LocalTime.of(0, 20), LocalTime.of(0, 20), 50D, 1, 50D, 3, 120D, 100, business);

        assertTrue(menu.getCategory().contains(MenuCategory.HAMBURGUESAS));
        assertTrue(menu.getDeliveryCost() == 40D);
        assertEquals(menu.getMaximumAmountSalesPerDay(), 100);
    }

    @Test
    public void calculatePrice_quantityFour_fourHundred() {

        List<MenuCategory> menuCategoryList = new ArrayList<>();
        menuCategoryList.add(MenuCategory.HAMBURGUESAS);

        Menu menu = MenuBuilder.aMenu().withCategories(menuCategoryList)
                .withAverageDeliveryTime(LocalTime.of(0, 20))
                .withDeliveryCost(0)
                .withDeliveryTime(LocalTime.of(0, 20))
                .withDescription("Hamburguesa de carne con tomate y queso")
                .withDueDate(LocalDate.now())
                .withPrice(120)
                .withMinimumQuantity(3)
                .withMinimumQuantityPrice(100)
                .withMinimumQuantityTwo(6)
                .withMinimumQuantityPriceTwo(80)
                .build();

        assertTrue(menu.calculatePrice(4) == 400D);
    }

    @Test
    public void calculatePrice_quantitySix_fourHundredAndEighty() {

        List<MenuCategory> menuCategoryList = new ArrayList<>();
        menuCategoryList.add(MenuCategory.HAMBURGUESAS);

        Menu menu = MenuBuilder.aMenu().withCategories(menuCategoryList)
                .withAverageDeliveryTime(LocalTime.of(0, 20))
                .withDeliveryCost(0)
                .withDeliveryTime(LocalTime.of(0, 20))
                .withDescription("Hamburguesa de carne con tomate y queso")
                .withDueDate(LocalDate.now())
                .withPrice(120)
                .withMinimumQuantity(3)
                .withMinimumQuantityPrice(100)
                .withMinimumQuantityTwo(6)
                .withMinimumQuantityPriceTwo(80)
                .build();

        assertTrue(menu.calculatePrice(6) == 480D);
    }
}
