
package com.unq.ViandasYaGrupoC2C022019.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

class Order {
    
    private Client client;
    private Business business;
    private List<Menu> menus = new ArrayList<Menu>();
    private DispatchType dispatchType;
    private LocalDate orderDate;
    private LocalDate dispatchDate;
    private OrederState state;
    private LocalTime dispatchTime;
    private LocalTime deliveryTime;
    private int score = 0;
    

    public Order(Client client, Business business, List<Menu> menus, DispatchType dispatchType, LocalDate dispatchDate, LocalTime deliveryTime) {
        this.client = client;
        this.business = business;
        this.menus = menus;
        this.dispatchType = dispatchType;
        this.dispatchDate = dispatchDate;
        this.orderDate = LocalDate.now();
        this.state = OrederState.PROGRESS;
        this.deliveryTime = deliveryTime;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public DispatchType getDispatchType() {
        return dispatchType;
    }

    public void setDispatchType(DispatchType dispatchType) {
        this.dispatchType = dispatchType;
    }

    public LocalDate getDispatchDate() {
        return dispatchDate;
    }

    public void setDispatchDate(LocalDate dispatchDate) {
        this.dispatchDate = dispatchDate;
    }

    public LocalTime getDispatchTime() {
        return dispatchTime;
    }

    public void setDispatchTime(LocalTime dispatchTime) {
        this.dispatchTime = dispatchTime;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public OrederState getState() {
        return state;
    }

    public void setState(OrederState state) {
        this.state = state;
    }

    public boolean hasQualification() {
        return this.getScore() != 0; 
    }

    public LocalTime calculateDeliveryTime(){
        LocalTime deliveryTime = this.menus.stream()
                .map(menu -> menu.getAverageDeliveryTime())
                .reduce(LocalTime.of(0,0),(t,t2)-> t.plus(t2.getHour(),ChronoUnit.HOURS)
                .plusMinutes(t2.getMinute()));
        if (this.dispatchType == DispatchType.BUSINESS)
            return deliveryTime;
        else
            return deliveryTime.plusHours(this.deliveryTime.getHour()).plusMinutes(this.deliveryTime.getMinute());
        
    }
    
}
