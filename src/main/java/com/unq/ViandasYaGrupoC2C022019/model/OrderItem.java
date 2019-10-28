package com.unq.ViandasYaGrupoC2C022019.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import org.springframework.data.annotation.Id;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @javax.persistence.Id
    private Long id;
    private int quantity;

    @ManyToOne
    private Menu menu;

    public OrderItem(int quantity, Menu menu) {
        this.quantity = quantity;
        this.menu = menu;
    }

    public OrderItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    
    public Double getPrice(){
        return this.menu.calculatePrice(this.quantity);
    }
}
