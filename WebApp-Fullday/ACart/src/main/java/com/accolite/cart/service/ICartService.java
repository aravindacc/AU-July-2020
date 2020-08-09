package com.accolite.cart.service;

import java.util.List;

import com.accolite.cart.models.Item;

public interface ICartService {

	public long addNewItem(Item item);
	
	public Item searchItem(String keyTxt);
	
	public Item updateItem(Item item);
	
	public List<Item> getAll();
	
	public boolean delete(int id);
	
	public List<Item> getRecentItems();
}
