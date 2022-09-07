package com.quinnox.ShoppingService;

public class fashion {
	
	private int id;
	private String type;
	private String item_name;
	private int item_price;
	
	
	public fashion(int id, String type, String item_name, int item_price) {
		super();
		this.id = id;
		this.type = type;
		this.item_name = item_name;
		this.item_price = item_price;
	}
	public fashion() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public int getItem_price() {
		return item_price;
	}
	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}
	@Override
	public String toString() {
		return "fashion [id=" + id + ", type=" + type + ", item_name=" + item_name + ", item_price=" + item_price + "]";
	}
	public static Object stream() {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	
}
