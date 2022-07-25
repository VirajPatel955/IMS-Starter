package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.DBUtils;



public class OrderItemDAO implements Dao<OrderItem> {
	
	public static final Logger LOGGER  = LogManager.getLogger();
	
	public OrderItem modelFromResultSet(ResultSet resultSet) throws SQLException {

		Long fk_order_id = resultSet.getLong("fk_order_id");
		int quantity_ordered = resultSet.getInt("quantity_ordered");
		Long fk_item_id = resultSet.getLong("fk_item_id");
		return new OrderItem(fk_order_id, quantity_ordered, fk_item_id);
}
  
	@Override
	public List<OrderItem> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orderitems");) {
			List<OrderItem> orderitems = new ArrayList<>();
			while (resultSet.next()) {
				orderitems.add(modelFromResultSet(resultSet));
			}
			return orderitems;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public OrderItem readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orderitems ORDER BY id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public OrderItem create(OrderItem orderitem) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO orderitems(fk_order_id, quantity_ordered, fk_item_id) VALUES (?, ?, ?)");) {
			System.out.println(orderitem);
			statement.setLong(1,orderitem.getFk_order_id());
			statement.setInt(2,orderitem.getQuantity_ordered());
			statement.setLong(3,orderitem.getFk_item_id());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	
	@Override
	public OrderItem read(Long fk_order_id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders WHERE fk_order_id = ?");) {
			statement.setLong(1, fk_order_id);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
		
	}


	@Override
	public OrderItem update(OrderItem orderitem) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE orderitems SET fk_order_id = ?, quantity_ordered = ?,fk_item_id = ?, WHERE fk_order_id = ?");) {
			statement.setLong(1,orderitem.getFk_order_id());
			statement.setInt(2,orderitem.getQuantity_ordered());
			statement.setLong(3,orderitem.getFk_item_id());
			statement.executeUpdate();
			return read(orderitem.getFk_order_id());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public int delete(long fk_order_id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM orderitems WHERE fk_order_id = ?");) {
			statement.setLong(1, fk_order_id);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

}
	