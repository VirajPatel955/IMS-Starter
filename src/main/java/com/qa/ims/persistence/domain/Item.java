package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Item {

	private Long item_id;
	private String item_title;
	private Double item_price;
	private int quantity;
	private int age_rating;
	
	public Item(String item_title, Double item_price, int quantity, int age_rating) {
		this.setItem_title(item_title);
		this.setItem_price(item_price);
		this.setQuantity(quantity);
		this.setAge_rating(age_rating);
	}
	
	public Item(Long item_id,String item_title, Double item_price, int quantity, int age_rating) {
		this.setItem_id(item_id);
		this.setItem_title(item_title);
		this.setItem_price(item_price);
		this.setQuantity(quantity);
		this.setAge_rating(age_rating);
	}
	
	
	public Long getItem_id() {
		return item_id;
	}
	public void setItem_id(Long item_id) {
		this.item_id = item_id;
	}
	
	
	public String getItem_title() {
		return item_title;
	}
	public void setItem_title(String item_title) {
		this.item_title = item_title;
	}
	
	
	public Double getItem_price() {
		return item_price;
	}
	public void setItem_price(Double item_price) {
		this.item_price = item_price;
	}
	
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	public int getAge_rating() {
		return age_rating;
	}
	public void setAge_rating(int age_rating) {
		this.age_rating = age_rating;
	}

	@Override
	public String toString() {
		return "item_id:" + item_id + " item_title:" + item_title + " item_price:" + item_price + " quantity:"
				+ quantity + " age_rating:" + age_rating;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age_rating, item_id, item_price, item_title, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return age_rating == other.age_rating && Objects.equals(item_id, other.item_id)
				&& Objects.equals(item_price, other.item_price) && Objects.equals(item_title, other.item_title)
				&& quantity == other.quantity;
	}
	
	
	
	
	
	
	

}