package com.unq.ViandasYaGrupoC2C022019.webservice;

import com.unq.ViandasYaGrupoC2C022019.aspects.LogExecutionTime;
import com.unq.ViandasYaGrupoC2C022019.dto.OrderDto;
import com.unq.ViandasYaGrupoC2C022019.model.Order;
import com.unq.ViandasYaGrupoC2C022019.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("order")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {

    @Autowired
    OrderService orderService;

    @LogExecutionTime
    @PostMapping("")
    public Order createOrder(@RequestBody OrderDto orderDto) {
        
        return orderService.saveFromOrderDto(orderDto);
    }
  
}
