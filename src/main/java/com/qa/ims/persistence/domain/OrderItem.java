package com.qa.ims.persistence.domain;

import java.util.Objects;

public class OrderItem {

	private Long fk_order_id;
	private int quantity_ordered;
	private Long fk_item_id;
	
	public OrderItem (Long fk_order_id, int quantity_ordered, Long fk_item_id) {
		this.setFk_order_id(fk_order_id);
		this.setQuantity_ordered(quantity_ordered);
		this.setFk_item_id(fk_item_id);
		
	}

	public Long getFk_order_id() {
		return fk_order_id;
	}

	public void setFk_order_id(Long fk_order_id) {
		this.fk_order_id = fk_order_id;
	}

	public int getQuantity_ordered() {
		return quantity_ordered;
	}

	public void setQuantity_ordered(int quantity_ordered) {
		this.quantity_ordered = quantity_ordered;
	}

	public Long getFk_item_id() {
		return fk_item_id;
	}

	public void setFk_item_id(Long fk_item_id) {
		this.fk_item_id = fk_item_id;
	}

	@Override
	public String toString() {
		return "OrderItem [fk_order_id=" + fk_order_id + ", quantity_ordered=" + quantity_ordered + ", fk_item_id="
				+ fk_item_id + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(fk_item_id, fk_order_id, quantity_ordered);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(fk_item_id, other.fk_item_id) && Objects.equals(fk_order_id, other.fk_order_id)
				&& quantity_ordered == other.quantity_ordered;
	}
	
	
	
}
