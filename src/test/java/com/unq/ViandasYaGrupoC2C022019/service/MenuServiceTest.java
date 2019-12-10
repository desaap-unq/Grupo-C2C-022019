package com.unq.ViandasYaGrupoC2C022019.service;

import com.unq.ViandasYaGrupoC2C022019.ApplicationTests;
import com.unq.ViandasYaGrupoC2C022019.model.Business;
import com.unq.ViandasYaGrupoC2C022019.model.Menu;
import com.unq.ViandasYaGrupoC2C022019.model.MenuCategory;
import com.unq.ViandasYaGrupoC2C022019.model.VirtualWallet;
import com.unq.ViandasYaGrupoC2C022019.util.BusinessBuilder;
import com.unq.ViandasYaGrupoC2C022019.util.MenuBuilder;
import com.unq.ViandasYaGrupoC2C022019.util.VirtualWalletBuilder;
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
        VirtualWallet virtualWallet = VirtualWalletBuilder.aVirtualWallet().buildAndSave(entityManager);

        Business business = BusinessBuilder.aBusiness().withWallet(virtualWallet).buildAndSave(entityManager);
        Menu menu = new Menu("Hamburgesa", "Hamburguesa de carne con tomate y queso",
                menuCategoryList, 40D, LocalDate.now(), LocalDate.now(),
                LocalTime.of(0, 20), LocalTime.of(0, 20), 50D, 1, 50D, 3, 120D, 100,business);
        this.menuService.save(menu);
        assertNotNull(menu.getId());
        assertThat(menu.getName()).isEqualTo("Hamburgesa");
        assertThat(menu.getDescription()).isEqualTo("Hamburguesa de carne con tomate y queso");
        assertThat(menu.getCategory()).containsExactly(MenuCategory.HAMBURGUESAS);
        assertTrue(menu.isActive());
        assertNotNull(menu.getCategory().get(0));
    }
    
    @Test
    public void update_MenuActive_MenuNotActive() {
        VirtualWallet virtualWallet = VirtualWalletBuilder.aVirtualWallet().buildAndSave(entityManager);
        Business business = BusinessBuilder.aBusiness().withWallet(virtualWallet).buildAndSave(entityManager);

        Menu menu = MenuBuilder.aMenu().withBusiness(business).buildAndPersist(entityManager);
        assertTrue(menu.isActive());
        menu.setActive(false);
        this.menuService.update(menu);
        Menu persistMenu = entityManager.find(Menu.class, menu.getId());
        assertFalse(persistMenu.isActive());
    }
    
    @Test
    public void findByBusinessId_menuExistInDataBase_ArrayMenu() {
        VirtualWallet virtualWallet = VirtualWalletBuilder.aVirtualWallet().buildAndSave(entityManager);
        Business business = BusinessBuilder.aBusiness().withWallet(virtualWallet).buildAndSave(entityManager);

        Menu menu = MenuBuilder.aMenu().withBusiness(business).buildAndPersist(entityManager);
        assertFalse(menuService.findByBusinessId(business.getId()).isEmpty());  

    }
    
    

}
