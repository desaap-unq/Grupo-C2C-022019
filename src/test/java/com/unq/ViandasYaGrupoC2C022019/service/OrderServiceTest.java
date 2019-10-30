package com.unq.ViandasYaGrupoC2C022019.service;

import com.unq.ViandasYaGrupoC2C022019.ApplicationTests;
import com.unq.ViandasYaGrupoC2C022019.dto.ItemDto;
import com.unq.ViandasYaGrupoC2C022019.dto.OrderDto;
import com.unq.ViandasYaGrupoC2C022019.model.Business;
import com.unq.ViandasYaGrupoC2C022019.model.Client;
import com.unq.ViandasYaGrupoC2C022019.model.Menu;
import com.unq.ViandasYaGrupoC2C022019.model.Order;
import com.unq.ViandasYaGrupoC2C022019.model.OrderItem;
import com.unq.ViandasYaGrupoC2C022019.model.VirtualWallet;
import com.unq.ViandasYaGrupoC2C022019.persistence.OrderItemRepository;
import com.unq.ViandasYaGrupoC2C022019.util.BusinessBuilder;
import com.unq.ViandasYaGrupoC2C022019.util.ClientBuilder;
import com.unq.ViandasYaGrupoC2C022019.util.MenuBuilder;
import com.unq.ViandasYaGrupoC2C022019.util.OrderBuilder;
import com.unq.ViandasYaGrupoC2C022019.util.VirtualWalletBuilder;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
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
    OrderItemRepository orderItemRepository;
    
    @Autowired
    EntityManager entityManager;
    
    @Test
    public void save_WithBasicData_AOrderWithIdNotNull() {
        VirtualWallet virtualWallet = VirtualWalletBuilder.aVirtualWallet().buildAndSave(entityManager);
        VirtualWallet virtualWalletClient = VirtualWalletBuilder.aVirtualWallet().buildAndSave(entityManager);
        
        Business businessSaved = BusinessBuilder.aBusiness().withWallet(virtualWallet).buildAndSave(entityManager);
        
        Client clientSaved =  ClientBuilder.aClient().withName("Ramon").withWallet(virtualWalletClient).buildAndSave(entityManager);
        
        Menu aMenu = MenuBuilder.aMenu().withBusiness(businessSaved).buildAndPersist(entityManager);
        Menu otherMenu = MenuBuilder.aMenu().withBusiness(businessSaved).buildAndPersist(entityManager);

        OrderItem orderItem = new OrderItem(1, aMenu);
        OrderItem orderItem2 = new OrderItem(1, otherMenu);
        List<OrderItem> orderItems = new ArrayList<>();
        
        orderItemRepository.save(orderItem);
        orderItemRepository.save(orderItem2);
        
        orderItems.add(orderItem);
        orderItems.add(orderItem2);
        
        
        Order aOrder = OrderBuilder.aOrder().withBusiness(businessSaved).withClient(clientSaved).withOrderItems(orderItems).build();//.buildAndSave(entityManager);
        orderService.save(aOrder);
        assertNotNull(aOrder.getId());
        assertNotNull(aOrder.getOrderItems());
        assertTrue(aOrder.getOrderItems().size() == 2);
        assertNotNull(aOrder.getOrderItems().get(0).getId());
    }    
    
    @Test
    public void saveFromOrderDto_OrderDtoWithBasicData_AOrderWithIdNotNull() {
        VirtualWallet virtualWallet = VirtualWalletBuilder.aVirtualWallet().buildAndSave(entityManager);
        VirtualWallet virtualWalletClient = VirtualWalletBuilder.aVirtualWallet().buildAndSave(entityManager);
        
        Business businessSaved = BusinessBuilder.aBusiness().withWallet(virtualWallet).buildAndSave(entityManager);
        
        Client clientSaved =  ClientBuilder.aClient().withName("Ramon").withWallet(virtualWalletClient).buildAndSave(entityManager);
        
        Menu aMenu = MenuBuilder.aMenu().withBusiness(businessSaved).buildAndPersist(entityManager);
        Menu otherMenu = MenuBuilder.aMenu().withBusiness(businessSaved).buildAndPersist(entityManager);

        ItemDto aItemDto = new ItemDto(aMenu.getId(),1);
        ItemDto otherItemDto =  new ItemDto(otherMenu.getId(),1);
        
        List<ItemDto> itemsDto = new ArrayList<ItemDto>();
        itemsDto.add(aItemDto);
        itemsDto.add(otherItemDto);
        
        OrderDto orderDto = new OrderDto(itemsDto,true,clientSaved.getId(),LocalDate.now(),LocalTime.now());
        
        Order  newOrder = orderService.saveFromOrderDto(orderDto);
        
        assertNotNull(newOrder.getId());
        assertNotNull(newOrder.getOrderItems());
        assertTrue(newOrder.getOrderItems().size() == 2);
        assertNotNull(newOrder.getOrderItems().get(0).getId());
        
    }
    
    @Test
    public void saveFromOrderDto_OrderDtoWithClientIdNotExists_AExeption() {
        VirtualWallet virtualWallet = VirtualWalletBuilder.aVirtualWallet().buildAndSave(entityManager);
        VirtualWallet virtualWalletClient = VirtualWalletBuilder.aVirtualWallet().buildAndSave(entityManager);
        
        Business businessSaved = BusinessBuilder.aBusiness().withWallet(virtualWallet).buildAndSave(entityManager);
        
        Client clientSaved =  ClientBuilder.aClient().withName("Ramon").withWallet(virtualWalletClient).build();
        clientSaved.setId(12L);
        
        Menu aMenu = MenuBuilder.aMenu().withBusiness(businessSaved).buildAndPersist(entityManager);
        Menu otherMenu = MenuBuilder.aMenu().withBusiness(businessSaved).buildAndPersist(entityManager);

        ItemDto aItemDto = new ItemDto(aMenu.getId(),1);
        ItemDto otherItemDto =  new ItemDto(otherMenu.getId(),1);
        
        List<ItemDto> itemsDto = new ArrayList<ItemDto>();
        itemsDto.add(aItemDto);
        itemsDto.add(otherItemDto);
        
        OrderDto orderDto = new OrderDto(itemsDto,true,clientSaved.getId(),LocalDate.now(),LocalTime.now());
        
        
        assertThatIllegalArgumentException()
                .isThrownBy(() -> orderService.saveFromOrderDto(orderDto))
                .withMessage("Not found Client with id 12");
        
    }
    
    @Test
    public void saveFromOrderDto_OrderDtoWithMenuIdNotExists_AException() {
        VirtualWallet virtualWallet = VirtualWalletBuilder.aVirtualWallet().buildAndSave(entityManager);
        VirtualWallet virtualWalletClient = VirtualWalletBuilder.aVirtualWallet().buildAndSave(entityManager);
        
        Business businessSaved = BusinessBuilder.aBusiness().withWallet(virtualWallet).buildAndSave(entityManager);
        
        Client clientSaved =  ClientBuilder.aClient().withName("Ramon").withWallet(virtualWalletClient).buildAndSave(entityManager);
        
        Menu aMenu = MenuBuilder.aMenu().withBusiness(businessSaved).build();
        aMenu.setId(101L);
        Menu otherMenu = MenuBuilder.aMenu().withBusiness(businessSaved).buildAndPersist(entityManager);

        ItemDto aItemDto = new ItemDto(aMenu.getId(),1);
        ItemDto otherItemDto =  new ItemDto(otherMenu.getId(),1);
        
        List<ItemDto> itemsDto = new ArrayList<ItemDto>();
        itemsDto.add(aItemDto);
        itemsDto.add(otherItemDto);
        
        OrderDto orderDto = new OrderDto(itemsDto,true,clientSaved.getId(),LocalDate.now(),LocalTime.now());
        
        assertThatIllegalArgumentException()
                .isThrownBy(() -> orderService.saveFromOrderDto(orderDto))
                .withMessage("Not found Menu with id 101");
                
    }
    
    @Test
    public void saveFromOrderDto_OrderDtoWithNegativeQuantity_AException() {
        VirtualWallet virtualWallet = VirtualWalletBuilder.aVirtualWallet().buildAndSave(entityManager);
        VirtualWallet virtualWalletClient = VirtualWalletBuilder.aVirtualWallet().buildAndSave(entityManager);
        
        Business businessSaved = BusinessBuilder.aBusiness().withWallet(virtualWallet).buildAndSave(entityManager);
        
        Client clientSaved =  ClientBuilder.aClient().withName("Ramon").withWallet(virtualWalletClient).buildAndSave(entityManager);
        
        Menu aMenu = MenuBuilder.aMenu().withBusiness(businessSaved).buildAndPersist(entityManager);
        Menu otherMenu = MenuBuilder.aMenu().withBusiness(businessSaved).buildAndPersist(entityManager);

        ItemDto aItemDto = new ItemDto(aMenu.getId(),-2);
        ItemDto otherItemDto =  new ItemDto(otherMenu.getId(),1);
        
        List<ItemDto> itemsDto = new ArrayList<ItemDto>();
        itemsDto.add(aItemDto);
        itemsDto.add(otherItemDto);
        
        OrderDto orderDto = new OrderDto(itemsDto,true,clientSaved.getId(),LocalDate.now(),LocalTime.now());
        
        assertThatIllegalArgumentException()
                .isThrownBy(() -> orderService.saveFromOrderDto(orderDto))
                .withMessage("Invalid quantity");
                
    }
}
