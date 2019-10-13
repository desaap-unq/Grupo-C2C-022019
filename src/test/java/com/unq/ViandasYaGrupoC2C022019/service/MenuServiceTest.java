package com.unq.ViandasYaGrupoC2C022019.service;

import com.unq.ViandasYaGrupoC2C022019.ApplicationTests;
import com.unq.ViandasYaGrupoC2C022019.model.Menu;
import com.unq.ViandasYaGrupoC2C022019.model.MenuBuilder;
import com.unq.ViandasYaGrupoC2C022019.model.MenuCategory;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class MenuServiceTest extends ApplicationTests{

    @Autowired
    private MenuService menuService;
    @Autowired
    EntityManager entityManager;

    @Test
    public void createMenu_WithBasicData_AMenu() {
        List<MenuCategory> menuCategoryList = new ArrayList<>();
        menuCategoryList.add(MenuCategory.HAMBURGUESAS);

        Menu menu = new Menu("Hamburgesa", "Hamburguesa de carne con tomate y queso",
                menuCategoryList, 40D, LocalDate.now(), LocalDate.now(),
                LocalTime.of(0, 20), LocalTime.of(0, 20), 50D, 1, 50D, 3, 120D, 100);
        this.menuService.save(menu);
        assertNotNull(menu.getId());
        assertThat(menu.getName()).isEqualTo("Hamburgesa");
        assertThat(menu.getDescription()).isEqualTo("Hamburguesa de carne con tomate y queso");
        assertThat(menu.getCategory()).containsExactly(MenuCategory.HAMBURGUESAS);
        assertTrue(menu.isActive());
    }
    
    @Test
    public void update_MenuActive_MenuNotActive() {
        Menu menu = MenuBuilder.aMenu().build(entityManager);
        assertTrue(menu.isActive());
        menu.setActive(false);
        this.menuService.update(menu);
        Menu persistMenu = entityManager.find(Menu.class, menu.getId());
        assertFalse(persistMenu.isActive());
    }
    
//    @Test
//    public void findByBusinessId_menuExistInDataBase_ArrayMenu() {
//        Menu menu = MenuBuilder.aMenu().build();
//        assertTrue(menu.isActive());
//    }
    
    

}
