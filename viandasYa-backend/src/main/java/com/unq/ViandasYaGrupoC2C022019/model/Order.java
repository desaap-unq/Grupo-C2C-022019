
package com.unq.ViandasYaGrupoC2C022019.model;

import java.util.ArrayList;
import java.util.List;

class Order {
    
    private Business business;
    private List<Menu> menus = new ArrayList<Menu>();
    private Client client;
    private int calification = 0;
    
    Order(Client aClient, Business aBusiness, List<Menu> menus) {
        this.business = aBusiness;
        this.client = aClient;
        this.menus = menus;
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

    public int getCalification() {
        return calification;
    }

    public void setCalification(int calification) {
        this.calification = calification;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    
    
}
