package com.unq.ViandasYaGrupoC2C022019.service;

import com.unq.ViandasYaGrupoC2C022019.dto.ItemDto;
import com.unq.ViandasYaGrupoC2C022019.dto.OrderDto;
import com.unq.ViandasYaGrupoC2C022019.model.Client;
import com.unq.ViandasYaGrupoC2C022019.model.DispatchType;
import com.unq.ViandasYaGrupoC2C022019.model.Menu;
import com.unq.ViandasYaGrupoC2C022019.model.Order;
import com.unq.ViandasYaGrupoC2C022019.model.OrderItem;
import com.unq.ViandasYaGrupoC2C022019.persistence.ClientRepository;
import com.unq.ViandasYaGrupoC2C022019.persistence.MenuRepository;
import com.unq.ViandasYaGrupoC2C022019.persistence.OrderItemRepository;
import com.unq.ViandasYaGrupoC2C022019.persistence.OrderRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order save(Order aOrder) {
        return this.orderRepository.save(aOrder);
    }

    public Order saveFromOrderDto(OrderDto aOrderdto) {
        validate(aOrderdto);
        
        Client client = clientRepository.findById(aOrderdto.getClientId()).get();

        List<OrderItem> orderItems = new ArrayList<OrderItem>();

        List<ItemDto> itemsDto = new ArrayList<ItemDto>();
        itemsDto = aOrderdto.getItems();
        orderItems = itemsDto.stream().map((item) -> this.convertDtoToItem(item.getMenuId(), item.getQuantity())).collect(Collectors.toList());
        orderItems.forEach(item -> orderItemRepository.save(item));

        Order newOrder = new Order();

        newOrder.setClient(client);
        newOrder.setOrderItems(orderItems);
        newOrder.setBusiness(orderItems.get(0).getMenu().getBusiness());
        newOrder.setDeliveryTime(aOrderdto.getDeliveryTime());
        newOrder.setDispatchDate(aOrderdto.getDispatchDate());
        
        
        if (aOrderdto.isDelivery()) {
            newOrder.setDispatchType(DispatchType.DELIVERY);
        } else {
            newOrder.setDispatchType(DispatchType.BUSINESS);
        }

        newOrder.setOrderDate(LocalDate.now());

        return orderRepository.save(newOrder);
    }

    private OrderItem convertDtoToItem(Long menuId, int quantity) {
        Menu aMenu = menuRepository.findById(menuId).get();
        return new OrderItem(quantity, aMenu);
    }
    
    private void validate(OrderDto aOrderDto){
        Assert.isTrue(clientRepository.existsById(aOrderDto.getClientId()), ("Not found Client with id ".concat(aOrderDto.getClientId().toString())));
        aOrderDto.getItems().forEach(item -> validateItems(item));
    }
    
    private void validateItems(ItemDto itemDto){
        Assert.isTrue(menuRepository.existsById(itemDto.getMenuId()), ("Not found Menu with id ".concat(itemDto.getMenuId().toString())));
        Assert.isTrue((itemDto.getQuantity()) > 0,("Invalid quantity"));
    }
}
