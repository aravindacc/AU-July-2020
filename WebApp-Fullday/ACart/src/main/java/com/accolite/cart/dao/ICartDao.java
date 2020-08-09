package com.accolite.cart.dao;

import java.util.List;

import com.accolite.cart.models.Item;

public interface ICartDao {

	public long addNewItem(Item item);
	
	public Item searchItem(String keyTxt);
	
	public int updateItem(Item item);
	
	public int delete(int id);
	
	public List<Item> getAll();
	
	public List<Item> getRecentItems();
}
