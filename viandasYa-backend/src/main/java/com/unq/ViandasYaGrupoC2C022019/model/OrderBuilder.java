
package com.unq.ViandasYaGrupoC2C022019.model;

import java.util.ArrayList;
import java.util.List;

public class OrderBuilder {
    public static OrderBuilder aOrder() {
        return new OrderBuilder();
    }

    private Business business;
    private List<Menu> menus = new ArrayList<Menu>();
    private Client client;
    private int calification = 0;
	
	public Order build() {
		Order aOrder = new Order(client, business, menus);
		return aOrder;
	}
	
	public OrderBuilder withMenu(Menu aMenu) {
		this.menus.add(aMenu);
		return this;
	}
        
        public OrderBuilder withBusiness(Business abusiness) {
		this.business = abusiness;
		return this;
	}
        
        public OrderBuilder withClient(Client aClient) {
		this.client = aClient;
		return this;
	}
        
        public OrderBuilder withCalification(int aCalification) {
		this.calification = aCalification;
		return this;
	}
        
}
