
package com.unq.ViandasYaGrupoC2C022019.dto;

public class ItemDto {
    
    private Long menuId;
    private int quantity;

    public ItemDto(){}
    
    public ItemDto(Long menuId, int quantity) {
        this.menuId = menuId;
        this.quantity = quantity;
    }
    
    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
