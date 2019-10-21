package com.unq.ViandasYaGrupoC2C022019.service;

import com.unq.ViandasYaGrupoC2C022019.ApplicationTests;
import com.unq.ViandasYaGrupoC2C022019.model.Business;
import com.unq.ViandasYaGrupoC2C022019.model.Client;
import com.unq.ViandasYaGrupoC2C022019.model.Menu;
import com.unq.ViandasYaGrupoC2C022019.model.Order;
import com.unq.ViandasYaGrupoC2C022019.model.VirtualWallet;
import com.unq.ViandasYaGrupoC2C022019.util.BusinessBuilder;
import com.unq.ViandasYaGrupoC2C022019.util.ClientBuilder;
import com.unq.ViandasYaGrupoC2C022019.util.MenuBuilder;
import com.unq.ViandasYaGrupoC2C022019.util.OrderBuilder;
import com.unq.ViandasYaGrupoC2C022019.util.VirtualWalletBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class OrderServiceTest extends ApplicationTests {
    
    @Autowired
    OrderService orderService;
    
    @Autowired
    EntityManager entityManager;
    
    @Test
    public void createOrder_WithBasicData_AOrderWithIdNotNull() {
        VirtualWallet virtualWallet = VirtualWalletBuilder.aVirtualWallet().buildAndSave(entityManager);
        VirtualWallet virtualWalletClient = VirtualWalletBuilder.aVirtualWallet().buildAndSave(entityManager);
        
        Business businessSaved = BusinessBuilder.aBusiness().withWallet(virtualWallet).buildAndSave(entityManager);
        
        Client clientSaved =  ClientBuilder.aClient().withName("Ramon").withWallet(virtualWalletClient).buildAndSave(entityManager);
        
        Menu aMenu = MenuBuilder.aMenu().withBusiness(businessSaved).buildAndPersist(entityManager);
        Menu otherMenu = MenuBuilder.aMenu().withBusiness(businessSaved).buildAndPersist(entityManager);
        List<Menu> menusSaved = new ArrayList<Menu>();
        menusSaved.add(aMenu);
        menusSaved.add(otherMenu);
        
        Order aOrder = OrderBuilder.aOrder().withBusiness(businessSaved).withClient(clientSaved).withMenus(menusSaved).buildAndSave(entityManager);
        orderService.save(aOrder);
        assertNotNull(aOrder.getId());
    }    
        
    
}
