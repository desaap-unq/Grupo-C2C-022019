package com.unq.ViandasYaGrupoC2C022019.service;

import com.unq.ViandasYaGrupoC2C022019.ApplicationTests;
import com.unq.ViandasYaGrupoC2C022019.model.Business;
import com.unq.ViandasYaGrupoC2C022019.model.Menu;
import com.unq.ViandasYaGrupoC2C022019.model.MenuCategory;
import com.unq.ViandasYaGrupoC2C022019.model.VirtualWallet;
import com.unq.ViandasYaGrupoC2C022019.util.BusinessBuilder;
import com.unq.ViandasYaGrupoC2C022019.util.VirtualWalletBuilder;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class BusinessServiceTest extends ApplicationTests {

    @Autowired
    private BusinessService businessService;
    
    @Autowired
    private MenuService menuService;

    @Autowired
    EntityManager entityManager;

    @Test
    public void createBussines_WithBasicData_ABusinessWithIdNotNull() {
        VirtualWallet virtualWallet = VirtualWalletBuilder.aVirtualWallet().buildAndSave(entityManager);
        Business business = BusinessBuilder.aBusiness().withWallet(virtualWallet).build();

        businessService.save(business);
        assertNotNull(business.getId());
    }

    @Test
    public void findBusinessById_WithBusinessInDataBase_ABusiness() {
        VirtualWallet virtualWallet = VirtualWalletBuilder.aVirtualWallet().buildAndSave(entityManager);
        Business businessSaved = BusinessBuilder.aBusiness().withWallet(virtualWallet).buildAndSave(entityManager);

        assertThat(businessService.findBusinessById(businessSaved.getId()).getId());

    }

    @Test
    public void findBusinessById_WithoutBusinessInDataBase_aException() {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> businessService.findBusinessById(1L))
                .withMessage("Not found Busness with id 1");
    }

    @Test
    public void testFindByCategory_Menu() {
        List<MenuCategory> menuCategoryList = new ArrayList<>();
        menuCategoryList.add(MenuCategory.HAMBURGUESAS);
        menuCategoryList.add(MenuCategory.EMPANADAS);

        VirtualWallet virtualWallet = VirtualWalletBuilder.aVirtualWallet().buildAndSave(entityManager);

        Business business = BusinessBuilder.aBusiness().withWallet(virtualWallet).buildAndSave(entityManager);

        Menu menu = new Menu("Hamburguesas", "Hamburguesa de carne con tomate y queso",
        menuCategoryList, 40D, LocalDate.now(), LocalDate.now(),
        LocalTime.of(0, 20), LocalTime.of(0, 20), 50D, 1, 50D, 3, 120D, 100, business);
        menuService.save(menu);
        assertFalse(businessService.findByCategory(MenuCategory.HAMBURGUESAS).isEmpty());  
    }

}
