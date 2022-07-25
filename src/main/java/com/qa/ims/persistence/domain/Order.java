package com.qa.ims.persistence.domain;



import java.util.Objects;

public class Order {

	private Long order_id;
	private String order_date;
	private Long fk_id;
	
	public Order(String order_date, Long fk_id) {
		this.setOrder_date(order_date);
		this.setFk_id(fk_id);
		
	}
	
	public Order(Long order_id, String order_date, Long fk_id) {
		this.setOrder_id(order_id);
		this.setOrder_date(order_date);
		this.setFk_id(fk_id);
	}

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public Long getFk_id() {
		return fk_id;
	}

	public void setFk_id(Long fk_id) {
		this.fk_id = fk_id;
	}

	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", order_date=" + order_date + ", fk_id=" + fk_id + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(fk_id, order_date, order_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(fk_id, other.fk_id) && Objects.equals(order_date, other.order_date)
				&& Objects.equals(order_id, other.order_id);
	}
	
	
	
}
