package com.maven.webapp.cart.service.impl;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.maven.webapp.cart.model.Item;
import com.maven.webapp.cart.service.CartDao;

@Repository
public class CartDaoImpl implements CartDao {

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
	
	public List<Item> searchItem(String name) {
		return jdbcTemplate.query("select * from item where itemNm like '%"+name+"%' or category like '%"+name+"%'", (rs,i)->{
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
	
	public List<Item> getAll(){
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
	public List<Item> getTopTen() {
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

	@Override
	public boolean deleteItem(int id) {
		return (jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(
					"delete from item where id = ?");
			ps.setInt(1, id);
			return ps;
		})>0);
	}
}