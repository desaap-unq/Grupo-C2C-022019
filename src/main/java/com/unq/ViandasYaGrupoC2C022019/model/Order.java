package com.unq.ViandasYaGrupoC2C022019.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
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
    @OneToMany
    private List<OrderItem> orderItems = new ArrayList<OrderItem>();
    @Enumerated(EnumType.ORDINAL)
    private DispatchType dispatchType; // tipo de entrega del pedido
    private LocalDate orderDate;  // fecha en la que se realizo el pedido
    private LocalDate dispatchDate; // fecha de entrega del pedido  (parametro)
    @Enumerated(EnumType.ORDINAL)
    private OrederState state;  // estado del pedido
    private LocalTime dispatchTime; // hora en la que se entrego el pedido
    private LocalTime deliveryTime; // hora en la que se debe entregar el ´pedido (parametro)
    private int score = 0;  //puntaje que se le dio al pedido
    private double totalPrice = 0;  
    
    
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
        this.calculateTotalPrice();
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

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
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
    
    public void calculateTotalPrice(){
        this.totalPrice = this.orderItems.stream()
                .map(item -> item.getPrice()).reduce( 0D, (price, price2) -> price + price2 );
    } 
    
}
