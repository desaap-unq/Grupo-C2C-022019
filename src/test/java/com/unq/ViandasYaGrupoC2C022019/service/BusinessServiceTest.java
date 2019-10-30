package com.unq.ViandasYaGrupoC2C022019.service;

import static org.junit.Assert.*;

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
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class BusinessServiceTest extends ApplicationTests {

    @Autowired
    private BusinessService businessService;

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

        assertThat(businessService.findBusinessById(businessSaved.getId()).getId()).isEqualTo(businessSaved.getId());

    }

//    @Test
//    public void findBusinessById_WithoutBusinessInDataBase_aException() {
//
//        assertThatIllegalArgumentException()
//                .isThrownBy(() -> businessService.findBusinessById(1L))
//                .withMessage("Not found Busness with id 1");
//    }

//    @Test
//    public void findByCategory_existBusinessWithCategory_ListWithABusiness() {
//        List<MenuCategory> menuCategoryList = new ArrayList<>();
//        menuCategoryList.add(MenuCategory.HAMBURGUESAS);
//        menuCategoryList.add(MenuCategory.EMPANADAS);
//
//        VirtualWallet virtualWallet = VirtualWalletBuilder.aVirtualWallet().buildAndSave(entityManager);
//        VirtualWallet otherVirtualWallet = VirtualWalletBuilder.aVirtualWallet().buildAndSave(entityManager);
//
//        Business business = BusinessBuilder.aBusiness().withWallet(virtualWallet).buildAndSave(entityManager);
//        Business Otherbusiness = BusinessBuilder.aBusiness().withWallet(otherVirtualWallet).buildAndSave(entityManager);
//
//        Menu aMenu = MenuBuilder.aMenu().withCategories(menuCategoryList)
//                .withAverageDeliveryTime(LocalTime.of(0, 20))
//                .withDeliveryCost(0)
//                .withDeliveryTime(LocalTime.of(0, 20))
//                .withDescription("Hamburguesa de carne con tomate y queso")
//                .withDueDate(LocalDate.now())
//                .withBusiness(business).buildAndPersist(entityManager);
//
//        Menu otherMenu = MenuBuilder.aMenu().withCategories(new ArrayList<MenuCategory>()).withBusiness(Otherbusiness).buildAndPersist(entityManager);
//
////        assertThat(businessService.findByCategory(MenuCategory.HAMBURGUESAS.name())).asList().isNotEmpty().size().isEqualTo(1);
//        Business recovery = businessService.findByCategory(MenuCategory.HAMBURGUESAS.name()).get(0);
//        assertEquals(recovery.getId(), business.getId());
//    }
//
//    @Test
//    public void findByCategory_notExistBusinessWithCategory_EmptyList() {
//        List<MenuCategory> menuCategoryList = new ArrayList<MenuCategory>();
//
//        VirtualWallet virtualWallet = VirtualWalletBuilder.aVirtualWallet().buildAndSave(entityManager);
//
//        Business business = BusinessBuilder.aBusiness().withWallet(virtualWallet).buildAndSave(entityManager);
//
//        MenuBuilder.aMenu().withCategories(menuCategoryList)
//                .withAverageDeliveryTime(LocalTime.of(0, 20))
//                .withDeliveryCost(0)
//                .withDeliveryTime(LocalTime.of(0, 20))
//                .withDescription("Hamburguesa de carne con tomate y queso")
//                .withDueDate(LocalDate.now())
//                .withBusiness(business).buildAndPersist(entityManager);
//
//        assertTrue(businessService.findByCategory(MenuCategory.HAMBURGUESAS.name()).isEmpty());
//    }

}
