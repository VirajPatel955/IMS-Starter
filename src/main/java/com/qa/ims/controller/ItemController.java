package com.qa.ims.controller;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

public class ItemController implements CrudController<Item> {
	
	public static final Logger LOGGER = LogManager.getLogger();
     
     private ItemDAO itemDAO;
     private Utils utils;
     
     public ItemController(ItemDAO itemDAO, Utils utils) {
    	 super();
    	 this.itemDAO = itemDAO;
    	 this.utils = utils;
    	 
     }
     
     

	@Override
	public List<Item> readAll() {
		List<Item> items = itemDAO.readAll();
		for (Item item : items) {
			LOGGER.info(item);
		}
		return items;
	}

	@Override
	public Item create() {
		LOGGER.info("Please enter a name of Item");
		String Item_title = utils.getString();
		LOGGER.info("Please enter a price of Item");
		Double Item_price = utils.getDouble();
		LOGGER.info("Please enter the amonut of the Item you want");
		int quantity = utils.getInt();
		LOGGER.info("Please enter the age rating");
		int age_rating = utils.getInt();
		
		Item item = itemDAO.create(new Item(Item_title,Item_price,quantity,age_rating));
		LOGGER.info("Item created");
		return item;
	}

	@Override
	public Item update() {
		LOGGER.info("Please enter the id of the item you would like to update");
		Long item_id = utils.getLong();
			LOGGER.info("Please enter a name of Item");
			String Item_title = utils.getString();
			LOGGER.info("Please enter a price of Item");
			Double Item_price = utils.getDouble();
			LOGGER.info("Please enter the amonut of the Item you want");
			int quantity = utils.getInt();
			LOGGER.info("Please enter the age rating");
			int age_rating = utils.getInt();
			
			Item item = itemDAO.create(new Item(item_id,Item_title,Item_price,quantity,age_rating));
			LOGGER.info("Item Updated");
			return item;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the item you would like to delete");
		Long item_id = utils.getLong();
		System.out.println ("Item deleted!");
		return itemDAO.delete(item_id);
		
	}

}
