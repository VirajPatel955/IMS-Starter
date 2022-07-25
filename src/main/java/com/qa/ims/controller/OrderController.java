package com.qa.ims.controller;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {
		
		public static final Logger LOGGER = LogManager.getLogger();
		
		private OrderDAO orderDAO;
		private Utils utils;
		
		public OrderController(OrderDAO orderDAO, Utils utils) {
			super();
			this.orderDAO = orderDAO;
			this.utils = utils;
		}
		
		@Override
		public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order);
		}
		return orders;
		
	}

		@Override
		public Order create() {
			LOGGER.info("Please enter the Order date");
			String Order_date = utils.getString();
			LOGGER.info("Please enter the id of the customer from the order");
			Long fk_id = utils.getLong();
			
			Order order = orderDAO.create(new Order(Order_date, fk_id));
			LOGGER.info("Order Created");
			return order;
		}

		@Override
		public Order update() {
			LOGGER.info("Please enter the id of the order you would like to update");
			Long order_id = utils.getLong();
			LOGGER.info("Please enter the date of the order");
		    String order_date = utils.getString();
			LOGGER.info("Please enter the id of the customer from this updated order");
			Long fk_id = utils.getLong();
			Order order = orderDAO.update(new Order(order_id, order_date, fk_id));
			LOGGER.info("Order Updated");
			return order;
			
		}

		@Override
		public int delete() {
			LOGGER.info("Please enter the id of the order you would like to delete");
			Long order_id = utils.getLong();
			System.out.println ("Order deleted!");
			return orderDAO.delete(order_id);
			
		}
	}
