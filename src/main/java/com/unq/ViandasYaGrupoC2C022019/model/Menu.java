package com.unq.ViandasYaGrupoC2C022019.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import org.springframework.data.annotation.Id;

@Entity
public class Menu implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @javax.persistence.Id
    private Long id;
    private String name;
    private String description;
    @ElementCollection
    @CollectionTable(name = "menu_category")
    @Enumerated(EnumType.STRING)
    private List<MenuCategory> category; 
    private double deliveryCost;
    private LocalDate startDate;
    private LocalDate dueDate;
    private LocalTime deliveryTime;
    private LocalTime averageDeliveryTime;
    private double price;
    private int minimumQuantity;
    private double minimumQuantityPrice;
    private int minimumQuantityTwo;
    private double minimumQuantityPriceTwo;
    private int maximumAmountSalesPerDay;
    private boolean active;
    @ManyToOne(fetch = FetchType.EAGER)
    private Business business;

    public Menu(String name, String description, List<MenuCategory> category,
            Double deliveryCost, LocalDate startDate, LocalDate dueDate,
            LocalTime deliveryTime, LocalTime averageDeliveryTime, Double price,
            int minimumQuantity, Double minimumQuantityPrice, int minimumQuantityTwo,
            Double minimumQuantityPriceTwo, int maximumAmountSalesPerDay, Business business) {

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
        this.minimumQuantityTwo = minimumQuantityTwo;
        this.minimumQuantityPriceTwo = minimumQuantityPriceTwo;
        this.maximumAmountSalesPerDay = maximumAmountSalesPerDay;
        this.business = business;
        this.active = true;
    }

    public Menu() {
    }

    public LocalTime getAverageDeliveryTime() {
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

    public int getMinimumQuantityTwo() {
        return minimumQuantityTwo;
    }

    public void setMinimumQuantityTwo(int minimumQuantitytwo) {
        this.minimumQuantityTwo = minimumQuantitytwo;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public Double calculatePrice(int quantity) {
        if (quantity == 1) {
            return this.getPrice();
        } else {
//            if (quantity >= this.minimumQuantityTwo) {
//                return quantity * minimumQuantityPriceTwo;
//            } else {
//                return quantity * minimumQuantityPrice;
//            }
            return this.getPrice()* quantity;
        }
    }

}
