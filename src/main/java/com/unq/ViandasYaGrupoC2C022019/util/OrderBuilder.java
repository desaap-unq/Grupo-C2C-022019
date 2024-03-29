
package com.unq.ViandasYaGrupoC2C022019.util;

import com.unq.ViandasYaGrupoC2C022019.model.Business;
import com.unq.ViandasYaGrupoC2C022019.model.Client;
import com.unq.ViandasYaGrupoC2C022019.model.DispatchType;
import com.unq.ViandasYaGrupoC2C022019.model.Menu;
import com.unq.ViandasYaGrupoC2C022019.model.Order;
import com.unq.ViandasYaGrupoC2C022019.model.OrderItem;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

public class OrderBuilder extends AbstractPersistenceBuilder<Order> {
    
    private Client client = new Client("Gabriel", "Guzman", "gabriel.guzman@alu.unq.edu.ar", 1515151515, 
                                    "Banfield", "Laprida 458");
    private Business business = new Business("Empanadas Dorita", "logo", "Lanus", "Av San Martin 3192", 
                                          "Google Use", "Empandas de todo tipo", "facebook", "no-resp@gmail.com",
                                          151515, "10 - 18", "lunes a viernes", "1km cerca de la estacion");
    private List<OrderItem> orderItems = new ArrayList<OrderItem>();
    private DispatchType dispatchType = DispatchType.BUSINESS ;
    private LocalDate dispatchDate = LocalDate.now();
    private LocalTime deliveryTime = LocalTime.of(0,20);
    
    public static OrderBuilder aOrder() {
        return new OrderBuilder();
    }
    
    public Order build() {
	Order aOrder = new Order(client, business, orderItems, dispatchType, dispatchDate,deliveryTime);
	return aOrder;
    }
	
    public OrderBuilder withOrderItems(List<OrderItem> orderItems) {
	this.orderItems = orderItems;
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
        
    public OrderBuilder withDispatchType(DispatchType aDispatchType) {
	this.dispatchType = aDispatchType;
	return this;
    }
        
    public OrderBuilder withDispatchDate(LocalDate aDispatchDate) {
	this.dispatchDate = aDispatchDate;
	return this;
    }
        
    public OrderBuilder withDeliveryTime(LocalTime aDeliveryTime) {
	this.deliveryTime = aDeliveryTime;
	return this;
    }
     public Order buildAndSave(EntityManager entityManager) {
        instance =  build();
        return super.build(entityManager);
    }
        
}
