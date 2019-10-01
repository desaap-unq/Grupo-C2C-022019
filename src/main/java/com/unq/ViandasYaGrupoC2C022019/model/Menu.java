package com.unq.ViandasYaGrupoC2C022019.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

class Menu {
    private String name; 
    private String description;
    private List<MenuCategory> category; 
    private double deliveryCost;
    private LocalDate startDate; 
    private LocalDate dueDate;
    private LocalTime deliveryTime;
    private LocalTime averageDeliveryTime; 
    private double price; 
    private int minimumQuantity;
    private double minimumQuantityPrice;
    private int minimumQuantitytwo;
    private double minimumQuantityPriceTwo;
    private int maximumAmountSalesPerDay;

    public Menu(String name, String description, List<MenuCategory> category,
                Double deliveryCost, LocalDate startDate, LocalDate dueDate, 
                LocalTime deliveryTime, LocalTime averageDeliveryTime, Double price,
                int minimumQuantity, Double minimumQuantityPrice, int minimumQuantitytwo,
                Double minimumQuantityPriceTwo, int maximumAmountSalesPerDay) {
        
        this.name = name;
        this.description = description;
        this.category = category;
        this.deliveryCost = deliveryCost;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.deliveryTime = deliveryTime;
        this.averageDeliveryTime = averageDeliveryTime;
        this.price = price;
        this.minimumQuantity = minimumQuantity;
        this.minimumQuantityPrice = minimumQuantityPrice;
        this.minimumQuantitytwo = minimumQuantitytwo;
        this.minimumQuantityPriceTwo = minimumQuantityPriceTwo;
        this.maximumAmountSalesPerDay = maximumAmountSalesPerDay;
    }

    public Menu(){}
    
    public LocalTime getAverageDeliveryTime(){
        return this.averageDeliveryTime;
    }

    public void setAverageDeliveryTime(LocalTime averageDeliveryTime) {
        this.averageDeliveryTime = averageDeliveryTime;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<MenuCategory> getCategory() {
        return category;
    }

    public void setCategory(List<MenuCategory> category) {
        this.category = category;
    }

    public Double getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(Double deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getMinimumQuantity() {
        return minimumQuantity;
    }

    public void setMinimumQuantity(int minimumQuantity) {
        this.minimumQuantity = minimumQuantity;
    }

    public Double getMinimumQuantityPrice() {
        return minimumQuantityPrice;
    }

    public void setMinimumQuantityPrice(Double minimumQuantityPrice) {
        this.minimumQuantityPrice = minimumQuantityPrice;
    }

    public int getMinimumQuantitytwo() {
        return minimumQuantitytwo;
    }

    public void setMinimumQuantitytwo(int minimumQuantitytwo) {
        this.minimumQuantitytwo = minimumQuantitytwo;
    }

    public Double getMinimumQuantityPriceTwo() {
        return minimumQuantityPriceTwo;
    }

    public void setMinimumQuantityPriceTwo(Double minimumQuantityPriceTwo) {
        this.minimumQuantityPriceTwo = minimumQuantityPriceTwo;
    }

    public int getMaximumAmountSalesPerDay() {
        return maximumAmountSalesPerDay;
    }

    public void setMaximumAmountSalesPerDay(int maximumAmountSalesPerDay) {
        this.maximumAmountSalesPerDay = maximumAmountSalesPerDay;
    }
    
}
