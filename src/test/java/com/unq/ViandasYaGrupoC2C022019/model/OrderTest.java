package com.unq.ViandasYaGrupoC2C022019.model;

import com.unq.ViandasYaGrupoC2C022019.util.MenuBuilder;
import com.unq.ViandasYaGrupoC2C022019.util.OrderBuilder;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OrderTest {

    @Test
    public void createOrder_newOrder() {
        Client aClient = new Client("Gabriel", "Guzman", "gabriel.guzman@alu.unq.edu.ar", 1515151515,
                "Banfield", "Laprida 458");

        Business aBusiness = new Business("Empanadas Dorita", "logo", "Lanus", "Av San Martin 3192",
                "Google Use", "Empandas de todo tipo", "facebook", "no-resp@gmail.com",
                151515, "10 - 18", "lunes a viernes", "1km cerca de la estacion");
        Menu aMenu = MenuBuilder.aMenu().build();

        OrderItem orderItem = new OrderItem(3, aMenu);
        OrderItem orderItem2 = new OrderItem(2, aMenu);
        List<OrderItem> orderItems = new ArrayList<OrderItem>();

        Order aOrder = new Order(aClient, aBusiness, orderItems, DispatchType.DELIVERY, LocalDate.now(), LocalTime.of(0, 25));

        assertEquals(aOrder.getBusiness(), aBusiness);
        assertEquals(aOrder.getClient(), aClient);
        assertEquals(aOrder.getState(), OrederState.PROGRESS);
        assertEquals(aOrder.getDispatchType(), DispatchType.DELIVERY);
        assertFalse(aOrder.hasQualification());
    }

    @Test
    public void hasQualifyOrder_withOutQualifyOrder_returnFalse() {
        Order aOrder = OrderBuilder.aOrder().build();
        assertFalse(aOrder.hasQualification());
    }

    @Test
    public void hasQualifyOrder_withQualifyOrder_returnTrue() {
        Order aOrder = OrderBuilder.aOrder().build();
        aOrder.setScore(5);
        assertTrue(aOrder.hasQualification());
    }

    @Test
    public void calculateDeliveryTime_withDispatchTypeBusiness_returnThirtyMinutes() {
        Menu aMockMenu = mock(Menu.class);
        when(aMockMenu.getAverageDeliveryTime()).thenReturn(LocalTime.of(0, 15));

        Menu otherMockMenu = mock(Menu.class);
        when(otherMockMenu.getAverageDeliveryTime()).thenReturn(LocalTime.of(0, 15));

        OrderItem orderItem = new OrderItem(1, aMockMenu);
        OrderItem orderItem2 = new OrderItem(1, otherMockMenu);
        List<OrderItem> orderItems = new ArrayList<>();

        orderItems.add(orderItem);
        orderItems.add(orderItem2);

        Order aOrder = OrderBuilder.aOrder().withOrderItems(orderItems).withDispatchType(DispatchType.BUSINESS).build();
        assertEquals(LocalTime.of(0, 30), aOrder.calculateDeliveryTime());
    }

    @Test
    public void calculateDeliveryTime_withDispatchTypeDelivery_returnThirtyMinutes() {
        Menu aMockMenu = mock(Menu.class);
        when(aMockMenu.getAverageDeliveryTime()).thenReturn(LocalTime.of(0, 15));

        Menu otherMockMenu = mock(Menu.class);
        when(otherMockMenu.getAverageDeliveryTime()).thenReturn(LocalTime.of(0, 15));

        OrderItem orderItem = new OrderItem(1, aMockMenu);
        OrderItem orderItem2 = new OrderItem(1, otherMockMenu);
        List<OrderItem> orderItems = new ArrayList<>();

        orderItems.add(orderItem);
        orderItems.add(orderItem2);

        Order aOrder = OrderBuilder.aOrder()
                .withOrderItems(orderItems)
                .withDispatchType(DispatchType.DELIVERY)
                .withDeliveryTime(LocalTime.of(0, 25))
                .build();
        assertEquals(aOrder.calculateDeliveryTime(), LocalTime.of(0, 55));
    }
}
