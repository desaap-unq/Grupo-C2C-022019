package com.unq.ViandasYaGrupoC2C022019.service;

import com.unq.ViandasYaGrupoC2C022019.ApplicationTests;
import com.unq.ViandasYaGrupoC2C022019.model.Business;
import com.unq.ViandasYaGrupoC2C022019.model.Client;
import com.unq.ViandasYaGrupoC2C022019.model.Menu;
import com.unq.ViandasYaGrupoC2C022019.model.Order;
import com.unq.ViandasYaGrupoC2C022019.model.OrderItem;
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
import static org.junit.Assert.assertTrue;
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

        OrderItem orderItem = new OrderItem(1, aMenu);
        OrderItem orderItem2 = new OrderItem(1, otherMenu);
        List<OrderItem> orderItems = new ArrayList<>();

        orderItems.add(orderItem);
        orderItems.add(orderItem2);
        
        
        
        
        Order aOrder = OrderBuilder.aOrder().withBusiness(businessSaved).withClient(clientSaved).withOrderItems(orderItems).build();//.buildAndSave(entityManager);
        orderService.save(aOrder);
        assertNotNull(aOrder.getId());
        assertNotNull(aOrder.getOrderItems());
        assertTrue(aOrder.getOrderItems().size() == 2);
       // assertNotNull(aOrder.getOrderItems().get(0).getId());
    }    
        
    
}
