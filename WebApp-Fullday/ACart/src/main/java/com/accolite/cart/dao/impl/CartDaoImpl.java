package com.accolite.cart.dao.impl;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.accolite.cart.dao.ICartDao;
import com.accolite.cart.models.Item;

@Repository
public class CartDaoImpl implements ICartDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public long addNewItem(Item item) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(
					"insert into item(itemNm, price, category, description, imageUrl) values(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, item.getName());
			ps.setInt(2, item.getPrice());
			ps.setString(3, item.getCategory());
			ps.setString(4, item.getDescription());
			ps.setString(5, item.getImageUrl());
			return ps;
		}, keyHolder);
		return keyHolder.getKey().longValue();
	}
	
	@Override
	public Item searchItem(String keyTxt) {
		  List<Item> items = jdbcTemplate.query("select * from item where itemNm like '%"+keyTxt
				  +"%' or category like '%"+keyTxt+"%'", (rs,i)->{
			  	Item item = new Item();
			  	item.setId(rs.getInt(1));
			  	item.setName(rs.getString(2));
			  	item.setPrice(rs.getInt(3));
			  	item.setCategory(rs.getString(4));
			  	item.setDescription(rs.getString(5));
			  	item.setImageUrl(rs.getString(6));
				return item;
			});
		return items.get(0);
	}

	@Override
	public int updateItem(Item item) {
		return jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(
					"update item set itemNm = ?, price = ?, category = ?, description = ?, imageUrl = ? where id = ?", Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, item.getName());
			ps.setInt(2, item.getPrice());
			ps.setString(3, item.getCategory());
			ps.setString(4, item.getDescription());
			ps.setString(5, item.getImageUrl());
			ps.setInt(6, item.getId());
			return ps;
		});
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(
					"delete from item where id = ?", Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, id);
			return ps;
		});
	}

	@Override
	public List<Item> getAll() {
		return jdbcTemplate.query("select * from item", (rs,i)->{
			Item item = new Item();
		  	item.setId(rs.getInt(1));
		  	item.setName(rs.getString(2));
		  	item.setPrice(rs.getInt(3));
		  	item.setCategory(rs.getString(4));
		  	item.setDescription(rs.getString(5));
		  	item.setImageUrl(rs.getString(6));
			return item;
		});
	}
	
	@Override
	public List<Item> getRecentItems() {
		return jdbcTemplate.query("select * from item order by id desc limit 10", (rs,i)->{
			Item item = new Item();
		  	item.setId(rs.getInt(1));
		  	item.setName(rs.getString(2));
		  	item.setPrice(rs.getInt(3));
		  	item.setCategory(rs.getString(4));
		  	item.setDescription(rs.getString(5));
		  	item.setImageUrl(rs.getString(6));
			return item;
		});
	}
	
}
