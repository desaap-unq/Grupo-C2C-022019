package com.unq.ViandasYaGrupoC2C022019.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class OrderDto {

    private List<ItemDto> items;
    private boolean delivery;
    private Long clientId;
    private LocalDate dispatchDate;
    private LocalTime deliveryTime;

    public OrderDto(List<ItemDto> items, boolean delivery, Long clientId, LocalDate dispatchDate, LocalTime deliveryTime) {
        this.items = items;
        this.delivery = delivery;
        this.clientId = clientId;
        this.dispatchDate = dispatchDate;
        this.deliveryTime = deliveryTime;
    }

    public OrderDto() {
    }

    public LocalDate getDispatchDate() {
        return dispatchDate;
    }

    public void setDispatchDate(LocalDate dispatchDate) {
        this.dispatchDate = dispatchDate;
    }

    public LocalTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public List<ItemDto> getItems() {
        return items;
    }

    public void setItems(List<ItemDto> items) {
        this.items = items;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

}
