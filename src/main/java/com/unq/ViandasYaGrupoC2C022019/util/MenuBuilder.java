package com.unq.ViandasYaGrupoC2C022019.util;

import com.unq.ViandasYaGrupoC2C022019.model.Menu;
import com.unq.ViandasYaGrupoC2C022019.model.MenuCategory;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

public class MenuBuilder extends AbstractPersistenceBuilder<Menu>{

    public static MenuBuilder aMenu() {
        return new MenuBuilder();
    }

    private String name = "no name";
    private String description = "no description";
    private List<MenuCategory> category = new ArrayList<MenuCategory>();
    private double deliveryCost = 0d;
    private LocalDate startDate = LocalDate.now();
    private LocalDate dueDate = LocalDate.now();
    private LocalTime deliveryTime = LocalTime.of(0, 20);
    private LocalTime averageDeliveryTime = LocalTime.of(0, 20);
    private double price = 0;
    private int minimumQuantity = 1;
    private double minimumQuantityPrice = 10d;
    private int minimumQuantityTwo = 2;
    private double minimumQuantityPriceTwo = 20d;
    private int maximumAmountSalesPerDay = 10;
    
    public MenuBuilder withName(String name){
        this.name = name;
        return this;
    }
    public MenuBuilder withDescription(String description){
        this.description = description;
        return this;
    }
    public MenuBuilder withCategories(List<MenuCategory> category){
        this.category = category;
        return this;
    }
    public MenuBuilder withDeliveryCost(double deliveryCost){
        this.deliveryCost = deliveryCost;
        return this;
    }
    public MenuBuilder withStartDate(LocalDate startDate){
        this.startDate = startDate;
        return this;
    }
    public MenuBuilder withDueDate(LocalDate dueDate){
        this.dueDate = dueDate;
        return this;
    }
    public MenuBuilder withDeliveryTime(LocalTime deliveryTime){
        this.deliveryTime = deliveryTime;
        return this;
    }
    public MenuBuilder withAverageDeliveryTime(LocalTime averageDeliveryTime){
        this.averageDeliveryTime = averageDeliveryTime;
        return this;
    }
    public MenuBuilder withPrice(double price){
        this.price = price;
        return this;
    }
    public MenuBuilder withMinimumQuantity(int minimumQuantity){
        this.minimumQuantity = minimumQuantity;
        return this;
    }
    public MenuBuilder withMinimumQuantityPrice(double minimumQuantityPrice){
        this.minimumQuantityPrice = minimumQuantityPrice;
        return this;
    }
    public MenuBuilder withMinimumQuantityTwo(int minimumQuantityTwo){
        this.minimumQuantityTwo = minimumQuantityTwo;
        return this;
    }
    public MenuBuilder withMinimumQuantityPriceTwo(double minimumQuantityPriceTwo){
        this.minimumQuantityPriceTwo = minimumQuantityPriceTwo;
        return this;
    }
    public MenuBuilder withMaximumAmountSalesPerDay(int maximumAmountSalesPerDay){
        this.maximumAmountSalesPerDay = maximumAmountSalesPerDay;
        return this;
    }
    
    public Menu build() {
        Menu aMenu = new Menu(
        name, description, category, deliveryCost, startDate, dueDate, deliveryTime, averageDeliveryTime,
        price, minimumQuantity, minimumQuantityPrice, minimumQuantityTwo, minimumQuantityPriceTwo,
        maximumAmountSalesPerDay);
        return aMenu;
    }
    public Menu buildAndPersist(EntityManager entityManager) {
        instance = this.build();
        return super.build(entityManager);
    }
}
