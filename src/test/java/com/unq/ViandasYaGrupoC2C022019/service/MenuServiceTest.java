package com.unq.ViandasYaGrupoC2C022019.service;

import com.unq.ViandasYaGrupoC2C022019.ApplicationTests;
import com.unq.ViandasYaGrupoC2C022019.model.Menu;
import com.unq.ViandasYaGrupoC2C022019.model.MenuCategory;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MenuServiceTest extends ApplicationTests{

    @Autowired
    private MenuService menuService;

    @Test
    public void createMenu_AMenu() {
        List<MenuCategory> menuCategoryList = new ArrayList<>();
        menuCategoryList.add(MenuCategory.HAMBURGUESAS);

        Menu menu = new Menu("Hamburgesa", "Hamburguesa de carne con tomate y queso",
                menuCategoryList, 40D, LocalDate.now(), LocalDate.now(),
                LocalTime.of(0, 20), LocalTime.of(0, 20), 50D, 1, 50D, 3, 120D, 100);
        this.menuService.save(menu);
        assertNotNull(menu.getId());
    }

}
