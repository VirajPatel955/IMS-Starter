package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderItemDAO;

import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.Utils;

public class OrderItemController implements CrudController <OrderItem> {

	public static final Logger LOGGER = LogManager.getLogger();
	
	private OrderItemDAO orderitemDAO;
	private Utils utils;
	
	public OrderItemController(OrderItemDAO orderitemDAO, Utils utils) {
		super();
		this.orderitemDAO = orderitemDAO;
		this.utils = utils;
	}
		
		@Override
		public OrderItem create() {
			LOGGER.info("Please enter the id of the order from the orders");
			Long fk_order_id = utils.getLong();
			LOGGER.info("Please enter the Quantity ordered");
			int quantity_ordered = utils.getInt();
			LOGGER.info("Please enter the id of the item from the items");
			Long fk_item_id = utils.getLong();
			
			OrderItem orderitem = orderitemDAO.create(new OrderItem(fk_order_id, quantity_ordered, fk_item_id));
			LOGGER.info("Order Created");
			return orderitem;
		}

		@Override
		public OrderItem update() {
			LOGGER.info("Please enter the id of the orderitem you would like to update");
			Long fk_order_id = utils.getLong();
			LOGGER.info("Please enter the quanity ordered");
		    int quantity_ordered = utils.getInt();
			LOGGER.info("Please enter the id of the customer from this updated order");
			Long fk_item_id = utils.getLong();
			OrderItem orderitem = orderitemDAO.update(new OrderItem(fk_order_id, quantity_ordered, fk_item_id));
			LOGGER.info("Table Updated");
			return orderitem;
			
		}

		@Override
		public int delete() {
			LOGGER.info("Please enter the id of the order you would like to delete");
			Long fk_order_id = utils.getLong();
			System.out.println ("data deleted!");
			return orderitemDAO.delete(fk_order_id);
			
		}
		@Override
		public List<OrderItem> readAll() {
			List<OrderItem> orderitems = orderitemDAO.readAll();
			for (OrderItem orderitem : orderitems)
				LOGGER.info(orderitem);
			return null;
		}
	
}
