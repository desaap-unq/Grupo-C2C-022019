package com.unq.ViandasYaGrupoC2C022019.service;

import static org.junit.Assert.*;

import com.unq.ViandasYaGrupoC2C022019.ApplicationTests;
import com.unq.ViandasYaGrupoC2C022019.dto.BusinessDto;
import com.unq.ViandasYaGrupoC2C022019.model.Business;
import com.unq.ViandasYaGrupoC2C022019.model.MenuCategory;
import com.unq.ViandasYaGrupoC2C022019.model.VirtualWallet;
import com.unq.ViandasYaGrupoC2C022019.util.BusinessBuilder;
import com.unq.ViandasYaGrupoC2C022019.util.MenuBuilder;
import com.unq.ViandasYaGrupoC2C022019.util.VirtualWalletBuilder;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class BusinessServiceTest extends ApplicationTests {

    @Autowired
    private BusinessService businessService;
    @Autowired
    EntityManager entityManager;
    
    /**
     * Before running the tests, verify DatabaseLoader
     */
    
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

    @Test
    public void findBusinessById_WithoutBusinessInDataBase_aException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> businessService.findBusinessById(12L))
                .withMessage("Not found Busness with id 12");
    }

    @Test
    public void findByCategory_existBusinessWithCategory_ListWithABusiness() {
	   List<MenuCategory> menuCategoryList = new ArrayList<>();
	   menuCategoryList.add(MenuCategory.HAMBURGUESAS);
	   menuCategoryList.add(MenuCategory.EMPANADAS);
	
	   VirtualWallet virtualWallet = VirtualWalletBuilder.aVirtualWallet().buildAndSave(entityManager);
	   VirtualWallet otherVirtualWallet = VirtualWalletBuilder.aVirtualWallet().buildAndSave(entityManager);
	
	   Business business = BusinessBuilder.aBusiness().withWallet(virtualWallet).buildAndSave(entityManager);			// id 5
	   Business Otherbusiness = BusinessBuilder.aBusiness().withWallet(otherVirtualWallet).buildAndSave(entityManager); // id 6

       MenuBuilder.aMenu().withCategories(menuCategoryList)
                .withAverageDeliveryTime(LocalTime.of(0, 20))
                .withDeliveryCost(0)
                .withDeliveryTime(LocalTime.of(0, 20))
                .withDescription("Hamburguesa de carne con tomate y queso")
                .withDueDate(LocalDate.now())
                .withBusiness(business).buildAndPersist(entityManager);

        MenuBuilder.aMenu().withCategories(new ArrayList<MenuCategory>()).withBusiness(Otherbusiness)
        		   .buildAndPersist(entityManager);

        List<BusinessDto> recovery = businessService.findByCategory(MenuCategory.HAMBURGUESAS.name());
        
        assertThat(recovery).asList().isNotEmpty().size().isEqualTo(4);
        assertEquals(recovery.get(3).getName(), business.getName());
    }

    @Test
    public void findByCategory_notExistBusinessWithCategory_EmptyList() {
        VirtualWallet virtualWallet = VirtualWalletBuilder.aVirtualWallet().buildAndSave(entityManager);

        Business business = BusinessBuilder.aBusiness().withWallet(virtualWallet).buildAndSave(entityManager);

        MenuBuilder.aMenu().withCategories(Arrays.asList(MenuCategory.SUSHI))
                .withAverageDeliveryTime(LocalTime.of(0, 20))
                .withDeliveryCost(0)
                .withDeliveryTime(LocalTime.of(0, 20))
                .withDescription("Hamburguesa de carne con tomate y queso")
                .withDueDate(LocalDate.now())
                .withBusiness(business).buildAndPersist(entityManager);

        assertTrue(businessService.findByCategory(MenuCategory.VEGANO.name()).isEmpty());
    }

}
