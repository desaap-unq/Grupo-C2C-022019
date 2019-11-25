package com.unq.ViandasYaGrupoC2C022019.model;

public enum MenuCategory {
    PIZZA("PIZZA"), CERVEZA("CERVEZA"), HAMBURGUESAS("HAMBURGUESAS"),
    SUSHI("SUSHI"), EMPANADAS("EMPANADAS"), GREEN("GREEN"), VEGANO("VEGANO");
    
    private String value;
	
    MenuCategory(String value) {
    	this.value = value;
    }

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
