package com.unq.ViandasYaGrupoC2C022019.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "order_table")
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @javax.persistence.Id
    private Long id;
    @ManyToOne
    private Client client;
    @ManyToOne
    private Business business;
    @OneToMany(cascade =CascadeType.PERSIST)
    private List<OrderItem> orderItems = new ArrayList<OrderItem>();
    @Enumerated(EnumType.ORDINAL)
    private DispatchType dispatchType;
    private LocalDate orderDate;
    private LocalDate dispatchDate;
    @Enumerated(EnumType.ORDINAL)
    private OrederState state;
    private LocalTime dispatchTime;
    private LocalTime deliveryTime;
    private int score = 0;
    
    public Order() {
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public LocalTime getDeliveryTime() {
        return deliveryTime;
    }
    
    public void setDeliveryTime(LocalTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
    
    public Order(Client client, Business business, List<OrderItem> orderItems, DispatchType dispatchType, LocalDate dispatchDate, LocalTime deliveryTime) {
        this.client = client;
        this.business = business;
        this.orderItems = orderItems;
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
    
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
    
    public void addOrderItem(OrderItem orderItem) {
        this.orderItems.add(orderItem);
    }
    
    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
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
    
    public LocalTime calculateDeliveryTime() {
        LocalTime deliveryTime = this.orderItems.stream()
                .map(item -> item.getMenu()).map( menu ->( menu.getAverageDeliveryTime()))
                .reduce( LocalTime.of(0, 0), (t, t2) -> t.plus(t2.getHour(), ChronoUnit.HOURS)
                .plusMinutes(t2.getMinute()));
        if (this.dispatchType == DispatchType.BUSINESS) {
            return deliveryTime;
        } else {
            return deliveryTime.plusHours(this.deliveryTime.getHour()).plusMinutes(this.deliveryTime.getMinute());
        }
        
    }
    
}
